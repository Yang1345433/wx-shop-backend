package yangcdtu.cn.wxshop.dto.cart;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartAddDTO {
    private Long goodsId;
    private Long number;
    private Long productId;
}
