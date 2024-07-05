package yangcdtu.cn.wxshop.vo.cart;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CartTotalVO {
    private Integer goodsCount;
    private BigDecimal goodsAmount;
    private Integer checkedGoodsCount;
    private BigDecimal checkedGoodsAmount;
}
