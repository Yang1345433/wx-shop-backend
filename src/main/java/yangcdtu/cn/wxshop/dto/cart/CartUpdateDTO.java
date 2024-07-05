package yangcdtu.cn.wxshop.dto.cart;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartUpdateDTO {
    private Long id;
    private Integer number;
    private Long productId;
}
