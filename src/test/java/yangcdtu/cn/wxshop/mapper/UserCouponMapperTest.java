package yangcdtu.cn.wxshop.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import yangcdtu.cn.wxshop.entity.UserCoupon;
import yangcdtu.cn.wxshop.enums.UserCouponStatus;

import java.util.List;

@SpringBootTest
public class UserCouponMapperTest {
    @Autowired
    private UserCouponMapper userCouponMapper;

    @Test
    public void saveUserCoupons() {
        List.of(
                new UserCoupon(
                        null,
                        1L,
                        1L,
                        UserCouponStatus.UN_USED
                ),
                new UserCoupon(
                        null,
                        1L,
                        2L,
                        UserCouponStatus.UN_USED
                )
        ).forEach(item -> userCouponMapper.insert(item));
    }
}
