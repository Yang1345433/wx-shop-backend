package yangcdtu.cn.wxshop.vo.home;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class GrouponVO {
    private Long id;
    private Integer groupon_member;
    private BigDecimal groupon_price;
    private GoodsVO goods;
}
