package yangcdtu.cn.wxshop.vo.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserIndexVO {
    private UserIndexOrderVO order;
    private int totalAmount;
    private int remainAmount;
    private int couponCount;
}
