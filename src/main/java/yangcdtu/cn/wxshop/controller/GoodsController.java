package yangcdtu.cn.wxshop.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yangcdtu.cn.wxshop.common.utils.MinioService;
import yangcdtu.cn.wxshop.dto.goods.GoodListQuery;
import yangcdtu.cn.wxshop.entity.Category;
import yangcdtu.cn.wxshop.enums.MinioBucketEnum;
import yangcdtu.cn.wxshop.service.CategoryService;
import yangcdtu.cn.wxshop.service.GoodsService;
import yangcdtu.cn.wxshop.vo.goods.*;

import java.math.BigDecimal;
import java.util.List;

@Tag(name = "商品")
@RestController
@RequestMapping("goods")
@AllArgsConstructor
public class GoodsController {
    private final MinioService minioService;
    private final CategoryService categoryService;
    private final GoodsService goodsService;
    @GetMapping("count")
    @Operation(summary = "数量")
    public GoodsCountVO getGoodsCount() {
        return new GoodsCountVO(100L);
    }
    @GetMapping("detail")
    @Operation(summary = "信息")
    public GoodsDetailVO getGoodsDetail(@RequestParam Long id) {
        return goodsService.getGoodsDetail(id);
    }

    @GetMapping("list")
    @Operation(summary = "商品列表")
    public GoodsPage getGoodsList(@ParameterObject GoodListQuery query) {
        if (query.getCategoryId() != null) return goodsService.getGoodsPageByCategory(query);
        if (query.getBrandId() != null) return goodsService.getGoodsPageByBrand(query);
        return new GoodsPage(
                List.of(
                        new GoodsVO(
                                1L,
                                minioService.getUrlForDownload(MinioBucketEnum.HOME_BANNER.getCode(), "head.png"),
                                "goods 1 name",
                                BigDecimal.valueOf(20.00)
                        ),
                        new GoodsVO(
                                2L,
                                minioService.getUrlForDownload(MinioBucketEnum.HOME_BANNER.getCode(), "head.png"),
                                "goods 2 name",
                                BigDecimal.valueOf(40.00)
                        )
                ),
                1L,
                List.of(
                        new CategoryDetailVO(
                                1L,
                                "category 1",
                                null
                        ),
                        new CategoryDetailVO(
                                1L,
                                "category 1",
                                null
                        )
                )
        );
    }

    @GetMapping("related")
    @Operation(summary = "关联商品")
    public List<GoodsVO> getRelatedGoodsList(@RequestParam Long id) {
        System.out.println(id);
        return List.of(
                new GoodsVO(
                        1L,
                        minioService.getUrlForDownload(MinioBucketEnum.HOME_BANNER.getCode(), "head.png"),
                        "related goods 1 name",
                        BigDecimal.valueOf(200.00)
                ),
                new GoodsVO(
                        2L,
                        minioService.getUrlForDownload(MinioBucketEnum.HOME_BANNER.getCode(), "head.png"),
                        "related goods 2 name",
                        BigDecimal.valueOf(400.00)
                )
        );
    }

    @GetMapping("category")
    @Operation(summary = "分类")
    public CategoryVO getGoodsCategory(@RequestParam Long id) {
        Category category = categoryService.getById(id);

        Category parentCategory = categoryService.getById(category.getParentId());

        List<Category> brotherCategory = categoryService.list(
                new LambdaQueryWrapper<Category>()
                        .eq(Category::getParentId, category.getParentId())
        );

        return new CategoryVO(
                toCategoryDetailVO(parentCategory),
                brotherCategory.stream().map(this::toCategoryDetailVO).toList(),
                toCategoryDetailVO(category)
        );
    }

    private CategoryDetailVO toCategoryDetailVO(Category category) {
        return new CategoryDetailVO(
                category.getId(),
                category.getName(),
                category.getFrontName()
        );
    }

}
