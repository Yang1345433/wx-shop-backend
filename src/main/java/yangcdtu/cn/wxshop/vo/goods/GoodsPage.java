package yangcdtu.cn.wxshop.vo.goods;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GoodsPage {
    private List<GoodsVO> goodsList;
    private Long totalPages;
    private List<CategoryDetailVO> filterCategoryList;
}
