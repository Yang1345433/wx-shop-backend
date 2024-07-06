package yangcdtu.cn.wxshop.vo.order;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class OrderGoodsVO {
    private Long orderId;
    private Long goodsId;
    private String picUrl;
    private String goodsName;
    private String specifications;
    private Long number;
    private BigDecimal price;
    private Integer comment;
}
