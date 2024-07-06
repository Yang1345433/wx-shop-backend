package yangcdtu.cn.wxshop.vo.cart;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartCheckoutAddressVO {
    private Long id;
    private String name;
    private Boolean isDefault;
    private String mobile;
    private String address;
}
