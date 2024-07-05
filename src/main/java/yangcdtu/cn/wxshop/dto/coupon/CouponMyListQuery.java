package yangcdtu.cn.wxshop.dto.coupon;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CouponMyListQuery {
    private Integer status;
    private Long page;
    private Long size;
}
