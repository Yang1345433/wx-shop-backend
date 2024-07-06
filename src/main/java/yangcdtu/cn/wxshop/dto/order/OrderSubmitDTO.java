package yangcdtu.cn.wxshop.dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderSubmitDTO {
    private Long cartId;
    private Long addressId;
    private Long couponId;
    private Long grouponLinkId;
    private Long grouponRulesId;
    private String message;
}
