package yangcdtu.cn.wxshop.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import yangcdtu.cn.wxshop.dto.cart.CartCheckedDTO;
import yangcdtu.cn.wxshop.dto.cart.CartFastAddDTO;
import yangcdtu.cn.wxshop.dto.cart.CartUpdateDTO;
import yangcdtu.cn.wxshop.security.SecurityUser;
import yangcdtu.cn.wxshop.service.CartService;
import yangcdtu.cn.wxshop.vo.cart.CartIndexVO;

@Tag(name = "购物车")
@RestController
@RequestMapping("cart")
@AllArgsConstructor
public class CartController {
    private final CartService cartService;
    @GetMapping("goodscount")
    @Operation(summary = "商品数量")
    public Integer getCartGoodsCount() {
        return 1;
    }



    @PostMapping("fastadd")
    @Operation(summary = "直接购买")
    public void fastAdd(@RequestBody CartFastAddDTO cartFastAdd) {
        System.out.println(cartFastAdd);
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

}
