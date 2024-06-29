package yangcdtu.cn.wxshop.vo.goods;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class GoodsInfoVO {
    private Long id;
    private List<String> gallery;
    private String picUrl;
    private String name;
    private String brief;
    private BigDecimal counterPrice;
    private BigDecimal retailPrice;
}
