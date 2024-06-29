package yangcdtu.cn.wxshop.vo.home;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class GoodsVO {
    private Long id;
    private String picUrl;
    private String name;
    private String brief;
    private BigDecimal counterPrice;
}
