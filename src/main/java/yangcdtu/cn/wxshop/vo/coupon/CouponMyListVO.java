package yangcdtu.cn.wxshop.vo.coupon;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CouponMyListVO {
    private List<CouponVO> data;
    private Long count;
}
