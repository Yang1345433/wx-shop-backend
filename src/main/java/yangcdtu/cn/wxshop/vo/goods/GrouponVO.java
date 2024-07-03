package yangcdtu.cn.wxshop.vo.goods;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class GrouponVO {
    private Long id;
    private Boolean checked;
    private String specification;
    private BigDecimal discount;
    private Integer discountMember;
}
