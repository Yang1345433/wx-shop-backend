package yangcdtu.cn.wxshop.vo.catalog;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CatalogIndexVO {
    private List<CategoryVO> categoryList;
    private CurrentCategoryVO currentCategory;
    private List<SubCategoryVO> currentSubCategory;
}
