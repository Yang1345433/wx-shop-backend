package yangcdtu.cn.wxshop.vo.goods;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GoodsDetailVO {
    private GoodsInfoVO info;
    private List<SpecificationVO> specificationList;
    private List<ProductVO> productList;
    private BrandVO brand;
    private CommentVO comment;
}
