package yangcdtu.cn.wxshop.vo.goods;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ProductVO {
    private Long id;
    private BigDecimal price;
    private String specifications;
    private Long number;
}
