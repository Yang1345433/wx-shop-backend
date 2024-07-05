package yangcdtu.cn.wxshop.vo.cart;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CartGoodsVO {
    private Long id;
    private Boolean checked;
    private Long productId;
    private String picUrl;
    private String goodsName;
    private Long number;
    private String goodsSpecificationValues;
    private BigDecimal price;

}
