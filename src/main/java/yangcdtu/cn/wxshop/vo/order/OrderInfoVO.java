package yangcdtu.cn.wxshop.vo.order;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class OrderInfoVO {
    private String orderSn;
    private String addTime;
    private String consignee;
    private String mobile;
    private String address;
    private String orderStatusText;
    private BigDecimal goodsPrice;
    private BigDecimal freightPrice;
    private BigDecimal discountPrice;
    private BigDecimal actualPrice;
    private OrderHandleOptionVO handleOption;

}
