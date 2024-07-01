package yangcdtu.cn.wxshop.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yangcdtu.cn.wxshop.vo.coupon.CouponVO;

import java.util.List;

@Tag(name = "优惠卷")
@RestController
@RequestMapping("coupon")
@AllArgsConstructor
public class CouponController {
    @GetMapping("getUserCoupon")
    @Operation(summary = "用户")
    public List<CouponVO> getUserCoupon() {
        return List.of();
    }
}
