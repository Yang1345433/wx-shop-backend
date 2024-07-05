package yangcdtu.cn.wxshop.service;

import yangcdtu.cn.wxshop.dto.coupon.CouponMyListQuery;
import yangcdtu.cn.wxshop.vo.coupon.CouponMyListVO;

public interface UserCouponService {
    CouponMyListVO getMyCoupons(CouponMyListQuery query);
}
