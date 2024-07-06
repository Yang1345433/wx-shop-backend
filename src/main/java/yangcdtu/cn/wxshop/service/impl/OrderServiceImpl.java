package yangcdtu.cn.wxshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yangcdtu.cn.wxshop.bo.OrderGoodsBO;
import yangcdtu.cn.wxshop.bo.OrderOtherInfoBO;
import yangcdtu.cn.wxshop.common.utils.MinioService;
import yangcdtu.cn.wxshop.dto.order.OrderListQuery;
import yangcdtu.cn.wxshop.dto.order.OrderSubmitDTO;
import yangcdtu.cn.wxshop.entity.*;
import yangcdtu.cn.wxshop.enums.MinioBucketEnum;
import yangcdtu.cn.wxshop.enums.OrderStatus;
import yangcdtu.cn.wxshop.mapper.*;
import yangcdtu.cn.wxshop.security.SecurityUser;
import yangcdtu.cn.wxshop.service.OrderService;
import yangcdtu.cn.wxshop.vo.address.AddressDetailVO;
import yangcdtu.cn.wxshop.vo.order.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    private final MinioService minioService;
    private final GoodsMapper goodsMapper;
    private final CartMapper cartMapper;
    private final ProductMapper productMapper;
    private final CouponMapper couponMapper;
    @Override
    public OrderPageVO orderPage(OrderListQuery query, Long userId) {
        Page<Order> page = page(
                Page.of(query.getPage(), query.getSize()),
                new LambdaQueryWrapper<Order>()
                        .eq(Order::getUserId, userId)
                        .eq(query.getShowType() != 0, Order::getStatus, OrderStatus.byShowType(query.getShowType()))
        );
        return new OrderPageVO(
                page.getRecords().stream().map(this::toOrderVO).toList(),
                page.getPages()
        );
    }

    @Override
    public OrderDetailVO getDetail(Long id) {
        Order order = getById(id);
        return new OrderDetailVO(
                toOrderInfoVO(order),
                order.getOtherInfo().getOrderGoods().stream().map(item -> toOrderGoodsVO(item, id)).toList()
        );
    }

    @Transactional
    @Override
    public Long saveOrder(OrderSubmitDTO submit, AddressDetailVO address) {
        List<Cart> carts = cartMapper.selectList(
                new LambdaUpdateWrapper<Cart>()
                        .eq(submit.getCartId() != 0, Cart::getId, submit.getCartId())
        );

        long count = count();

        Coupon coupon = couponMapper.selectById(submit.getCouponId());
        BigDecimal discount = coupon != null ? coupon.getDiscount() : BigDecimal.valueOf(0);

        BigDecimal goodsPrice = BigDecimal.valueOf(0);


        for (Cart item : carts) {
            Product product = productMapper.selectById(item.getProductId());
            goodsPrice = goodsPrice.add(product.getPrice().multiply(BigDecimal.valueOf(item.getNumber())));
        }

        Order order = new Order(
                null,
                SecurityUser.getUserId(),
                LocalDate.now().toString() + count,
                LocalDate.now().toString(),
                address.getName(),
                address.getMobile(),
                address.getProvinceName() + address.getCityName() + address.getAreaName() + address.getAddress(),
                OrderStatus.DUE,
                new OrderOtherInfoBO(
                        carts.stream().map(item -> toOrderGoodsBO(item.getProductId(), item.getNumber())).toList(),
                        goodsPrice,
                        BigDecimal.valueOf(10),
                        discount,
                        goodsPrice.add(BigDecimal.valueOf(10)).subtract(discount)
                )
        );

        save(order);

        cartMapper.deleteBatchIds(carts.stream().map(Cart::getId).toList());

        return order.getId();
    }

    private OrderGoodsBO toOrderGoodsBO(Long productId, Long number) {
        Product product = productMapper.selectById(productId);
        Goods goods = goodsMapper.selectById(product.getGoodsId());
        return new OrderGoodsBO(
                goods.getId(),
                goods.getName(),
                product.getSpecifications(),
                number,
                product.getPrice(),
                0
        );
    }

    private OrderInfoVO toOrderInfoVO(Order order) {
        return new OrderInfoVO(
                order.getOrderSn(),
                order.getAddTime(),
                order.getConsignee(),
                order.getMobile(),
                order.getAddress(),
                order.getStatus().getDescription(),
                order.getOtherInfo().getGoodsPrice(),
                order.getOtherInfo().getFreightPrice(),
                order.getOtherInfo().getDiscountPrice(),
                order.getOtherInfo().getActualPrice(),
                getHandler(order.getStatus())
        );
    }

    private OrderVO toOrderVO(Order order) {
        return new OrderVO(
                order.getId(),
                order.getOrderSn(),
                order.getStatus().getDescription(),
                order.getOtherInfo().getActualPrice(),
                order.getOtherInfo().getOrderGoods().stream().map(item -> toOrderGoodsVO(item, order.getId())).toList(),
                getHandler(order.getStatus())
        );
    }

    private OrderGoodsVO toOrderGoodsVO(OrderGoodsBO orderGoods, Long orderId) {
        Goods goods = goodsMapper.selectById(orderGoods.getGoodsId());
        return new OrderGoodsVO(
                orderId,
                orderGoods.getGoodsId(),
                minioService.getUrlForDownload(MinioBucketEnum.GOODS.getCode(), goods.getId().toString() + goods.getPicUrl()),
                orderGoods.getGoodsName(),
                orderGoods.getSpecifications(),
                orderGoods.getNumber(),
                orderGoods.getPrice(),
                orderGoods.getComment()
        );
    }

    private OrderHandleOptionVO getHandler(OrderStatus status) {
        return new OrderHandleOptionVO(
                status == OrderStatus.COMMENT,
                status == OrderStatus.COMMENT,
                status == OrderStatus.DUE,
                status == OrderStatus.DUE,
                status == OrderStatus.RECEIVE,
                status == OrderStatus.COMMENT,
                status == OrderStatus.COMMENT || status == OrderStatus.RECEIVE || status == OrderStatus.SENT
        );
    }
}
