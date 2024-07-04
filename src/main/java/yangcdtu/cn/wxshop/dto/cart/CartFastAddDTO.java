package yangcdtu.cn.wxshop.dto.cart;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartFastAddDTO {
    private Long goodsId;
    private Long number;
    private Long productId;
}
