package yangcdtu.cn.wxshop.vo.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserIndexVO {
    private UserIndexOrderVO order;
    private Long totalAmount;
    private Long remainAmount;
    private Long couponCount;
}
