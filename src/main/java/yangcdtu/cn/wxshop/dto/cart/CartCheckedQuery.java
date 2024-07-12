package yangcdtu.cn.wxshop.dto.cart;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartCheckedQuery {
    private Long cartId;
    private Long addressId;
    private Long couponId;
    private Long grouponRulesId;
}