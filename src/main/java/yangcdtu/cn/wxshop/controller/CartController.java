package yangcdtu.cn.wxshop.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;
import yangcdtu.cn.wxshop.dto.cart.*;
import yangcdtu.cn.wxshop.entity.Cart;
import yangcdtu.cn.wxshop.entity.Coupon;
import yangcdtu.cn.wxshop.mapper.CouponMapper;
import yangcdtu.cn.wxshop.security.SecurityUser;
import yangcdtu.cn.wxshop.service.AddressService;
import yangcdtu.cn.wxshop.service.CartService;
import yangcdtu.cn.wxshop.service.UserCouponService;
import yangcdtu.cn.wxshop.vo.address.AddressDetailVO;
import yangcdtu.cn.wxshop.vo.cart.CartCheckoutAddressVO;
import yangcdtu.cn.wxshop.vo.cart.CartCheckoutVO;
import yangcdtu.cn.wxshop.vo.cart.CartGoodsVO;
import yangcdtu.cn.wxshop.vo.cart.CartIndexVO;

import java.math.BigDecimal;
import java.util.List;

@Tag(name = "购物车")
@RestController
@RequestMapping("cart")
@AllArgsConstructor
public class CartController {
    private final CartService cartService;
    private final AddressService addressService;
    private final UserCouponService userCouponService;
    private final CouponMapper couponMapper;
    @GetMapping("goodscount")
    @Operation(summary = "商品数量")
    public Long getCartGoodsCount() {
        if (SecurityUser.getUser() == null) return 0L;
        return cartService.count(
                new LambdaQueryWrapper<Cart>()
                        .eq(Cart::getUserId, SecurityUser.getUserId())
        );
    }



    @PostMapping("fastadd")
    @Operation(summary = "直接购买")
    public Long fastAdd(@RequestBody CartFastAddDTO cartFastAdd) {
        return cartService.saveCart(cartFastAdd.getProductId(), cartFastAdd.getNumber());
    }

    @PostMapping("add")
    @Operation(summary = "添加")
    public Long addCart(@RequestBody CartAddDTO add) {
        cartService.saveCart(add.getProductId(), add.getNumber());
        return cartService.count(
                new LambdaQueryWrapper<Cart>()
                        .eq(Cart::getUserId, SecurityUser.getUserId())
        );
    }

    @PostMapping("delete")
    @Operation(summary = "删除")
    public CartIndexVO deleteCarts(@RequestBody CartDeleteDTO delete) {
        cartService.remove(
                new LambdaQueryWrapper<Cart>()
                        .in(Cart::getProductId, delete.getProductIds())
        );
        return new CartIndexVO(
                0,
                cartService.getUserTotal(SecurityUser.getUserId()),
                cartService.getCartGoodsByUser(SecurityUser.getUserId())
        );
    }

    @GetMapping("index")
    @Operation(summary = "购物车首页")
    public CartIndexVO cartIndex() {
        return new CartIndexVO(
                0,
                cartService.getUserTotal(SecurityUser.getUserId()),
                cartService.getCartGoodsByUser(SecurityUser.getUserId())
        );
    }

    @PostMapping("checked")
    @Operation(summary = "选择")
    public CartIndexVO cartChecked(@RequestBody CartCheckedDTO checked) {
        cartService.checkedCartByUser(SecurityUser.getUserId(), checked.getProductIds(), checked.getIsChecked());
        return new CartIndexVO(
                0,
                cartService.getUserTotal(SecurityUser.getUserId()),
                cartService.getCartGoodsByUser(SecurityUser.getUserId())
        );
    }

    @PostMapping("update")
    @Operation(summary = "变更")
    public void updateCart(@RequestBody CartUpdateDTO update) {
        cartService.updateNumber(update.getId(), update.getNumber());
    }

    @GetMapping("checkout")
    @Operation(summary = "检查")
    public CartCheckoutVO cartCheckout(@ParameterObject CartCheckoutQuery query) {
        List<CartGoodsVO> goods = cartService.getCheckedCartGoods(query.getCartId());

        BigDecimal goodsTotalPrice = BigDecimal.valueOf(0);

        for (CartGoodsVO item : goods) {
            goodsTotalPrice = goodsTotalPrice.add(item.getPrice());
        }

        BigDecimal couponPrice;
        Coupon coupon = couponMapper.selectById(query.getCouponId());
        if (coupon != null) couponPrice = coupon.getDiscount();
        else couponPrice = BigDecimal.valueOf(0);

        BigDecimal freightPrice = BigDecimal.valueOf(10);

        return new CartCheckoutVO(
                false,
                cartService.getCheckedCartGoods(query.getCartId()),
                toCartCheckoutAddressVO(addressService.getDetail(query.getAddressId())),
                userCouponService.getLeastUseCoupon(SecurityUser.getUserId(), goodsTotalPrice),
                goodsTotalPrice.subtract(couponPrice).add(freightPrice),
                couponPrice,
                freightPrice,
                goodsTotalPrice,
                query.getAddressId(),
                query.getCouponId(),
                query.getGrouponRulesId()
        );
    }

    private CartCheckoutAddressVO toCartCheckoutAddressVO(AddressDetailVO address) {
        return new CartCheckoutAddressVO(
                address.getId(),
                address.getName(),
                address.getIsDefault(),
                address.getMobile(),
                address.getProvinceName() + " " + address.getCityName() + " " + address.getAreaName() + " " + address.getAddress()
        );
    }

}
