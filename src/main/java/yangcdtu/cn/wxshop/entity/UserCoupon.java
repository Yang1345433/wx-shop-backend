package yangcdtu.cn.wxshop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import yangcdtu.cn.wxshop.enums.UserCouponStatus;

@TableName("user_coupon")
@Data
@AllArgsConstructor
public class UserCoupon {
    private Long id;
    private Long userId;
    private Long couponId;
    private UserCouponStatus status;
}
