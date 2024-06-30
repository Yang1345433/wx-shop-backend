package yangcdtu.cn.wxshop.dto.goods;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GoodListQuery {
    private Long brandId;
    private Long categoryId;
    private Long page;
    private Long size;
}
