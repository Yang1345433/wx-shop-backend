package yangcdtu.cn.wxshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import yangcdtu.cn.wxshop.common.utils.MinioService;
import yangcdtu.cn.wxshop.entity.Cart;
import yangcdtu.cn.wxshop.entity.Goods;
import yangcdtu.cn.wxshop.entity.Product;
import yangcdtu.cn.wxshop.enums.MinioBucketEnum;
import yangcdtu.cn.wxshop.mapper.CartMapper;
import yangcdtu.cn.wxshop.mapper.GoodsMapper;
import yangcdtu.cn.wxshop.mapper.ProductMapper;
import yangcdtu.cn.wxshop.security.SecurityUser;
import yangcdtu.cn.wxshop.service.CartService;
import yangcdtu.cn.wxshop.vo.cart.CartGoodsVO;
import yangcdtu.cn.wxshop.vo.cart.CartTotalVO;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {
    private final ProductMapper productMapper;
    private final GoodsMapper goodsMapper;
    private final MinioService minioService;
    @Override
    public CartTotalVO getUserTotal(Long userId) {
        List<Cart> carts = this.list(
                new LambdaQueryWrapper<Cart>()
                        .eq(Cart::getUserId, userId)
        );

        BigDecimal goodsTotal = BigDecimal.valueOf(0.0);
        BigDecimal goodsCheckedTotal = BigDecimal.valueOf(0.0);

        int goodsCheckedNumber = 0;

        for (Cart cart : carts) {
            Product product = productMapper.selectById(cart.getProductId());

            BigDecimal cartTotal = product.getPrice().multiply(BigDecimal.valueOf(cart.getNumber()));

            goodsTotal = goodsTotal.add(cartTotal);

            if (cart.getChecked()) {
                goodsCheckedNumber++;
                goodsCheckedTotal = goodsCheckedTotal.add(cartTotal);
            }
        }

        return new CartTotalVO(
                carts.size(),
                goodsTotal,
                goodsCheckedNumber,
                goodsCheckedTotal
        );
    }

    @Override
    public List<CartGoodsVO> getCartGoodsByUser(Long userId) {
        return this.list(
                new LambdaQueryWrapper<Cart>()
                        .eq(Cart::getUserId, userId)
        ).stream().map(this::toCartGoodsVO).toList();
    }

    @Override
    public void checkedCartByUser(Long userId, List<Long> productIds, Boolean isChecked) {
        update(
                new LambdaUpdateWrapper<Cart>()
                        .eq(Cart::getUserId, userId)
                        .in(Cart::getProductId, productIds)
                        .set(Cart::getChecked, isChecked)
        );
    }

    @Override
    public void updateNumber(Long cartId, Integer number) {
        update(
                new LambdaUpdateWrapper<Cart>()
                        .eq(Cart::getId, cartId)
                        .set(Cart::getNumber, number)
        );
    }

    @Override
    public List<CartGoodsVO> getCheckedCartGoods(Long cartId) {
        if (cartId != 0) {
            return list(
                    new LambdaQueryWrapper<Cart>()
                            .eq(Cart::getId, cartId)
            ).stream().map(this::toCartGoodsVO).toList();
        }
        return list(
                new LambdaQueryWrapper<Cart>()
                        .eq(Cart::getUserId, SecurityUser.getUserId())
                        .eq(Cart::getChecked, true)
        ).stream().map(this::toCartGoodsVO).toList();
    }

    @Override
    public Long saveCart(Long productId, Long number) {
        Cart cart = new Cart(null, SecurityUser.getUserId(), true, productId, number);
        save(cart);
        return cart.getId();
    }

    private CartGoodsVO toCartGoodsVO(Cart cart) {
        Product product = productMapper.selectById(cart.getProductId());
        Goods goods = goodsMapper.selectById(product.getGoodsId());

        return new CartGoodsVO(
                cart.getId(),
                cart.getChecked(),
                cart.getProductId(),
                minioService.getUrlForDownload(MinioBucketEnum.GOODS.getCode(), goods.getId().toString() + goods.getPicUrl()),
                goods.getName(),
                cart.getNumber(),
                product.getSpecifications(),
                product.getPrice()
        );
    }
}
