package yangcdtu.cn.wxshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import yangcdtu.cn.wxshop.dto.coupon.CouponMyListQuery;
import yangcdtu.cn.wxshop.entity.Coupon;
import yangcdtu.cn.wxshop.entity.UserCoupon;
import yangcdtu.cn.wxshop.enums.UserCouponStatus;
import yangcdtu.cn.wxshop.mapper.CouponMapper;
import yangcdtu.cn.wxshop.mapper.UserCouponMapper;
import yangcdtu.cn.wxshop.security.SecurityUser;
import yangcdtu.cn.wxshop.service.UserCouponService;
import yangcdtu.cn.wxshop.vo.coupon.CouponMyListVO;
import yangcdtu.cn.wxshop.vo.coupon.CouponVO;

import java.util.List;

@Service
@AllArgsConstructor
public class UserCouponServiceImpl implements UserCouponService {
    private final CouponMapper couponMapper;
    private final UserCouponMapper userCouponMapper;

    @Override
    public CouponMyListVO getMyCoupons(CouponMyListQuery query) {
        List<Long> couponIds = userCouponMapper.selectList(
                new LambdaQueryWrapper<UserCoupon>()
                        .eq(UserCoupon::getUserId, SecurityUser.getUserId())
                        .eq(UserCoupon::getStatus, UserCouponStatus.byCode(query.getStatus()))
        ).stream().map(UserCoupon::getCouponId).toList();

        return toCouponMyListVO(
                couponMapper.selectPage(
                        Page.of(query.getPage(), query.getSize()),
                        new LambdaQueryWrapper<Coupon>()
                                .in(Coupon::getId, couponIds)
                )
        );
    }

    private CouponMyListVO toCouponMyListVO(Page<Coupon> couponPage) {
        return new CouponMyListVO(couponPage.getRecords().stream().map(this::toCouponVO).toList(), couponPage.getTotal());
    }

    private CouponVO toCouponVO(Coupon coupon) {
        return new CouponVO(
                coupon.getId(),
                coupon.getTag(),
                coupon.getDiscount(),
                coupon.getName(),
                coupon.getDescription(),
                coupon.getMin(),
                coupon.getDays(),
                coupon.getStartTime(),
                coupon.getEndTime()
        );
    }
}
