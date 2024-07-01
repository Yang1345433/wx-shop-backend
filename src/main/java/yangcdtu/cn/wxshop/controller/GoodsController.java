package yangcdtu.cn.wxshop.controller;

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
import yangcdtu.cn.wxshop.enums.MinioBucketEnum;
import yangcdtu.cn.wxshop.vo.goods.*;

import java.math.BigDecimal;
import java.util.List;

@Tag(name = "商品")
@RestController
@RequestMapping("goods")
@AllArgsConstructor
public class GoodsController {
    private final MinioService minioService;
    @GetMapping("count")
    @Operation(summary = "数量")
    public GoodsCountVO getGoodsCount() {
        return new GoodsCountVO(100L);
    }
    @GetMapping("detail")
    @Operation(summary = "信息")
    public GoodsDetailVO getGoodsDetail(@RequestParam Long id) {
        System.out.println(id);
        return new GoodsDetailVO(
                new GoodsInfoVO(
                        1L,
                        List.of(
                                minioService.getUrlForDownload(MinioBucketEnum.HOME_BANNER.getCode(), "head.png"),
                                minioService.getUrlForDownload(MinioBucketEnum.HOME_BANNER.getCode(), "head.png")
                        ),
                        minioService.getUrlForDownload(MinioBucketEnum.HOME_CHANNEL.getCode(), "dfh.png"),
                        "goods 1",
                        "brief",
                        BigDecimal.valueOf(30.00),
                        BigDecimal.valueOf(20.00),
                        "<h1>detail content</h1>"
                ),
                List.of(
                        new SpecificationVO(
                                List.of(
                                        new SpecificationValueVO(1L, false, BigDecimal.valueOf(20.00))
                                )
                        )
                ),
                List.of(
                        new ProductVO(BigDecimal.valueOf(20.00))
                ),
                new BrandVO(1L, "brand name"),
                new CommentVO(
                        2,
                        List.of(
                                new CommentDetailVO(
                                        minioService.getUrlForDownload(MinioBucketEnum.HOME_BANNER.getCode(), "head.png"),
                                        "comment name 1",
                                        "2024-06-28",
                                        "comment content 1",
                                        List.of(
                                                minioService.getUrlForDownload(MinioBucketEnum.HOME_BANNER.getCode(), "head.png"),
                                                minioService.getUrlForDownload(MinioBucketEnum.HOME_BANNER.getCode(), "head.png")
                                        )
                                ),
                                new CommentDetailVO(
                                        minioService.getUrlForDownload(MinioBucketEnum.HOME_BANNER.getCode(), "head.png"),
                                        "comment name 2",
                                        "2024-06-28",
                                        "comment content 2",
                                        List.of(
                                                minioService.getUrlForDownload(MinioBucketEnum.HOME_BANNER.getCode(), "head.png"),
                                                minioService.getUrlForDownload(MinioBucketEnum.HOME_BANNER.getCode(), "head.png")
                                        )
                                )
                        )
                ),
                List.of(
                        new AttributeVO("attribute 1", "value 1"),
                        new AttributeVO("attribute 2", "value 2")
                ),
                List.of(
                        new IssueVO("question 1", "answer 1"),
                        new IssueVO("question 2", "answer 2")
                )
        );
    }

    @GetMapping("list")
    @Operation(summary = "商品列表")
    public GoodsPage getGoodsList(@ParameterObject GoodListQuery query) {
        System.out.println(query);
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
        System.out.println(id);
        return new CategoryVO(
                new CategoryDetailVO(1L, "parent category", null),
                List.of(
                        new CategoryDetailVO(2L, "brother category 1", null),
                        new CategoryDetailVO(3L, "brother category 2", null)
                ),
                new CategoryDetailVO(2L, "current category 1", "front name")
        );
    }

}
