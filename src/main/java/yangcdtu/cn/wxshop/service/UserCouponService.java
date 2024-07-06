package yangcdtu.cn.wxshop.service;

import yangcdtu.cn.wxshop.dto.coupon.CouponMyListQuery;
import yangcdtu.cn.wxshop.vo.coupon.CouponMyListVO;

import java.math.BigDecimal;

public interface UserCouponService {
    CouponMyListVO getMyCoupons(CouponMyListQuery query);
    Long getLeastUseCoupon(Long userId, BigDecimal min);
}
