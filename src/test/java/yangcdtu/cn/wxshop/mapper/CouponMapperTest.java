package yangcdtu.cn.wxshop.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import yangcdtu.cn.wxshop.entity.Coupon;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class CouponMapperTest {
    @Autowired
    private CouponMapper couponMapper;

    @Test
    public void saveCoupons() {
        List.of(
                new Coupon(
                        null,
                        "满减",
                        BigDecimal.valueOf(100.00),
                        "通用",
                        "购买该商城产品所可以使用的优惠卷",
                        BigDecimal.valueOf(200.00),
                        30,
                        LocalDate.now().toString(),
                        LocalDate.now().plusDays(30).toString()
                ),
                new Coupon(
                        null,
                        "满减",
                        BigDecimal.valueOf(200.00),
                        "通用",
                        "购买该商城产品所可以使用的优惠卷",
                        BigDecimal.valueOf(350.00),
                        30,
                        LocalDate.now().toString(),
                        LocalDate.now().plusDays(30).toString()
                )
        ).forEach(item -> couponMapper.insert(item));
    }
}
