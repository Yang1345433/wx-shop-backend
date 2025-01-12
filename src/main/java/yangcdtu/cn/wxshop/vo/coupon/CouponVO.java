package yangcdtu.cn.wxshop.vo.coupon;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CouponVO {
    private Long id;
    private String tag;
    private BigDecimal discount;
    private String name;
    private String desc;
    private BigDecimal min;
    private Integer days;
    private String startTime;
    private String endTime;

}
