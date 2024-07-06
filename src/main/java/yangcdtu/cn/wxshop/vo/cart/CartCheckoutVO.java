package yangcdtu.cn.wxshop.vo.cart;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class CartCheckoutVO {
    private boolean isMultiOrderModel;
    private List<CartGoodsVO> checkedGoodsList;
    private CartCheckoutAddressVO checkedAddress;
    private Long availableCouponLength;
    private BigDecimal actualPrice;
    private BigDecimal couponPrice;
    private BigDecimal freightPrice;
    private BigDecimal goodsTotalPrice;
    private Long addressId;
    private Long couponId;
    private Long grouponRulesId;
}
