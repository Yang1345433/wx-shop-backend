package yangcdtu.cn.wxshop.vo.groupon;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class GrouponVO {
    private Long id;
    private Integer groupon_member;
    private GoodsVO goods;
    private BigDecimal groupon_price;
}
