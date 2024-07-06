package yangcdtu.cn.wxshop.vo.order;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class OrderVO {
    private Long id;
    private String orderSn;
    private String orderStatusText;
    private BigDecimal actualPrice;
    private List<OrderGoodsVO> goodsList;
    private OrderHandleOptionVO handleOption;
}
