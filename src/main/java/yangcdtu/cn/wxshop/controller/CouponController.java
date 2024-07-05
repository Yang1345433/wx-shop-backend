package yangcdtu.cn.wxshop.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yangcdtu.cn.wxshop.dto.coupon.CouponMyListQuery;
import yangcdtu.cn.wxshop.dto.coupon.CouponSelectListQuery;
import yangcdtu.cn.wxshop.enums.UserCouponStatus;
import yangcdtu.cn.wxshop.service.UserCouponService;
import yangcdtu.cn.wxshop.vo.coupon.CouponMyListVO;
import yangcdtu.cn.wxshop.vo.coupon.CouponVO;

import java.util.List;

@Tag(name = "优惠卷")
@RestController
@RequestMapping("coupon")
@AllArgsConstructor
public class CouponController {
    private final UserCouponService userCouponService;
    @GetMapping("getUserCoupon")
    @Operation(summary = "用户")
    public List<CouponVO> getUserCoupon() {
        return List.of();
    }

    @GetMapping("mylist")
    @Operation(summary = "当前")
    public CouponMyListVO getMyCouponList(@ParameterObject CouponMyListQuery query) {
        return userCouponService.getMyCoupons(query);
    }

    @GetMapping("selectlist")
    @Operation(summary = "可用")
    public List<CouponVO> selectCouponList(@ParameterObject CouponSelectListQuery query) {
        System.out.println(query);
        return userCouponService.getMyCoupons(new CouponMyListQuery(UserCouponStatus.UN_USED.getCode(), 1L, 10L)).getData();
    }
}
