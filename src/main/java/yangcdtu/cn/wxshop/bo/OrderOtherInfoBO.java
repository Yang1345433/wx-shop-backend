package yangcdtu.cn.wxshop.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderOtherInfoBO {
    private List<OrderGoodsBO> orderGoods;
    private BigDecimal goodsPrice;
    private BigDecimal freightPrice;
    private BigDecimal discountPrice;
    private BigDecimal actualPrice;
}
