package yangcdtu.cn.wxshop.vo.order;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class OrderDetailVO {
    private OrderInfoVO orderInfo;
    private List<OrderGoodsVO> orderGoods;
}
