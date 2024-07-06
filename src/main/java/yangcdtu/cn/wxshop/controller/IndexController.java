package yangcdtu.cn.wxshop.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yangcdtu.cn.wxshop.common.utils.MinioService;
import yangcdtu.cn.wxshop.dto.brand.BrandPageQuery;
import yangcdtu.cn.wxshop.entity.Article;
import yangcdtu.cn.wxshop.entity.Category;
import yangcdtu.cn.wxshop.entity.Goods;
import yangcdtu.cn.wxshop.enums.MinioBucketEnum;
import yangcdtu.cn.wxshop.service.*;
import yangcdtu.cn.wxshop.vo.home.*;

import java.math.BigDecimal;
import java.util.List;

@Tag(name = "首页")
@RestController
@RequestMapping("home")
@AllArgsConstructor
public class IndexController {
    private final MinioService minioService;
    private final ArticleService articleService;
    private final IndexService indexService;
    private final BrandService brandService;
    private final GoodsService goodsService;
    private final CategoryService categoryService;
    @GetMapping("index")
    @Operation(summary = "数据")
    public HomeIndexInfoVO homeIndexInfo() {
        return new HomeIndexInfoVO(
                minioService.getObjectsNameByBucket(MinioBucketEnum.HOME_BANNER.getCode()).stream().map(
                        item -> new BannerVO(minioService.getUrlForDownload(MinioBucketEnum.HOME_BANNER.getCode(), item))
                ).toList(),
                indexService.getIndexChannel(),
                articleService.list().stream().map(Article::toVO).toList(),
                indexService.grouponList(),
                List.of(
                        new TopicVO(
                                1L,
                                minioService.getUrlForDownload(MinioBucketEnum.HOME_BANNER.getCode(), "head.png"),
                                "topic title 1",
                                BigDecimal.valueOf(100.00),
                                "topic sub title 1"
                        ),
                        new TopicVO(
                                2L,
                                minioService.getUrlForDownload(MinioBucketEnum.HOME_BANNER.getCode(), "head.png"),
                                "topic title 2",
                                BigDecimal.valueOf(200.00),
                                "topic sub title 2"
                        )
                ),
                brandService.getBrandList(new BrandPageQuery(1L, 2L)).getBrandList(),
                goodsService.page(Page.of(1, 2)).getRecords().stream().map(this::toNewGoodsVO).toList(),
                goodsService.page(Page.of(1, 2)).getRecords().stream().map(this::toHotGoodsVO).toList(),
                categoryService.list(
                        new LambdaQueryWrapper<Category>()
                                .eq(Category::getName, "电脑")
                ).stream().map(this::toFloorGoodsVO).toList()
        );
    }

    private NewGoodsVO toNewGoodsVO(Goods goods) {
        return new NewGoodsVO(
                goods.getId(),
                minioService.getUrlForDownload(MinioBucketEnum.GOODS.getCode(), goods.getId().toString() + goods.getPicUrl()),
                goods.getName(),
                goods.getRetailPrice()
        );
    }

    private HotGoodsVO toHotGoodsVO(Goods goods) {
        return new HotGoodsVO(
                goods.getId(),
                minioService.getUrlForDownload(MinioBucketEnum.GOODS.getCode(), goods.getId().toString() + goods.getPicUrl()),
                goods.getName(),
                goods.getBrief(),
                goods.getRetailPrice()
        );
    }

    private FloorGoodsVO toFloorGoodsVO(Category category) {
        return new FloorGoodsVO(
                category.getId(),
                category.getName(),
                goodsService.page(
                        Page.of(1, 2),
                        new LambdaQueryWrapper<Goods>()
                                .eq(Goods::getCategoryId, category.getId())
                ).getRecords().stream().map(this::toFloorGoodsDetailVO).toList()
        );
    }

    private FloorGoodsDetailVO toFloorGoodsDetailVO(Goods goods) {
        return new FloorGoodsDetailVO(
                goods.getId(),
                minioService.getUrlForDownload(MinioBucketEnum.GOODS.getCode(), goods.getId().toString() + goods.getPicUrl()),
                goods.getName(),
                goods.getRetailPrice()
        );
    }
}
