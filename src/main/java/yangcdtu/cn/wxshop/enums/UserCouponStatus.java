package yangcdtu.cn.wxshop.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import yangcdtu.cn.wxshop.common.exception.ServerException;

@Getter
@AllArgsConstructor
public enum UserCouponStatus {
    UN_USED(0, "未使用"),
    USED(1, "已使用"),
    PASS(2, "已过期");
    private final Integer code;
    private final String description;

    @SuppressWarnings("unused")
    public static UserCouponStatus byCode(Integer code) {
        for (UserCouponStatus item : UserCouponStatus.values()) {
            if (item.code.equals(code)) {
                return item;
            }
        }
        throw new ServerException("user coupon status wrong");
    }
}
