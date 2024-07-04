package yangcdtu.cn.wxshop.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import yangcdtu.cn.wxshop.dto.cart.CartFastAddDTO;

@Tag(name = "购物车")
@RestController
@RequestMapping("cart")
@AllArgsConstructor
public class CartController {
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

}
