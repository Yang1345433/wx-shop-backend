package yangcdtu.cn.wxshop.vo.goods;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class SpecificationValueVO {
    private Long id;
    private Boolean checked;
    private BigDecimal value;
}
