package yangcdtu.cn.wxshop.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderGoodsBO {
    private Long goodsId;
    private String goodsName;
    private String specifications;
    private Long number;
    private BigDecimal price;
    private Integer comment;
}
