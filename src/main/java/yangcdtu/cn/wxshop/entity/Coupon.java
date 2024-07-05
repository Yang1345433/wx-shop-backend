package yangcdtu.cn.wxshop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@TableName("coupon")
@Data
@AllArgsConstructor
public class Coupon {
    private Long id;
    private String tag;
    private BigDecimal discount;
    private String name;
    private String description;
    private BigDecimal min;
    private Integer days;
    private String startTime;
    private String endTime;
}
