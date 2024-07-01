package yangcdtu.cn.wxshop.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yangcdtu.cn.wxshop.common.utils.MinioService;
import yangcdtu.cn.wxshop.entity.Article;
import yangcdtu.cn.wxshop.enums.MinioBucketEnum;
import yangcdtu.cn.wxshop.service.ArticleService;
import yangcdtu.cn.wxshop.service.IndexService;
import yangcdtu.cn.wxshop.vo.article.ArticlesVO;
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
    @GetMapping("index")
    @Operation(summary = "数据")
    public HomeIndexInfoVO homeIndexInfo() {
        // 轮播图
        List<BannerVO> banners = minioService.getObjectsNameByBucket(MinioBucketEnum.HOME_BANNER.getCode()).stream().map(
                item -> new BannerVO(minioService.getUrlForDownload(MinioBucketEnum.HOME_BANNER.getCode(), item))
        ).toList();

        // 公告
        List<ArticlesVO> articles = articleService.list().stream().map(Article::toVO).toList();

        // 团购
        List<GrouponVO> grouponList = indexService.grouponList();

        return new HomeIndexInfoVO(
                banners,
                List.of(
                        new ChannelVO(
                                1L,
                                minioService.getUrlForDownload(MinioBucketEnum.HOME_CHANNEL.getCode(), "dfh.png"),
                                "火车"
                        )
                ),
                articles,
                grouponList,
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
                List.of(
                        new BrandVO(
                                1L,
                                minioService.getUrlForDownload(MinioBucketEnum.HOME_BANNER.getCode(), "head.png"),
                                "brand 1",
                                BigDecimal.valueOf(100.00)
                        ),
                        new BrandVO(
                                2L,
                                minioService.getUrlForDownload(MinioBucketEnum.HOME_BANNER.getCode(), "head.png"),
                                "brand2",
                                BigDecimal.valueOf(200.00)
                        )
                ),
                List.of(
                        new NewGoodsVO(
                                1L,
                                minioService.getUrlForDownload(MinioBucketEnum.HOME_BANNER.getCode(), "head.png"),
                                "new goods 1",
                                BigDecimal.valueOf(100.00)
                        ),
                        new NewGoodsVO(
                                1L,
                                minioService.getUrlForDownload(MinioBucketEnum.HOME_BANNER.getCode(), "head.png"),
                                "new goods 2",
                                BigDecimal.valueOf(200.00)
                        )
                ),
                List.of(
                        new HotGoodsVO(
                                1L,
                                minioService.getUrlForDownload(MinioBucketEnum.HOME_BANNER.getCode(), "head.png"),
                                "hot goods 1",
                                "brief 1",
                                BigDecimal.valueOf(100.00)
                        ),
                        new HotGoodsVO(
                                1L,
                                minioService.getUrlForDownload(MinioBucketEnum.HOME_BANNER.getCode(), "head.png"),
                                "new goods 2",
                                "brief 2",
                                BigDecimal.valueOf(200.00)
                        )
                ),
                List.of(
                        new FloorGoodsVO(
                                1L,
                                "floor good 1",
                                List.of(
                                        new FloorGoodsDetailVO(
                                                1L,
                                                minioService.getUrlForDownload(MinioBucketEnum.HOME_BANNER.getCode(), "head.png"),
                                                "floor good 1 sub 1",
                                                BigDecimal.valueOf(100.00)
                                        ),
                                        new FloorGoodsDetailVO(
                                                2L,
                                                minioService.getUrlForDownload(MinioBucketEnum.HOME_BANNER.getCode(), "head.png"),
                                                "floor good 1 sub 2",
                                                BigDecimal.valueOf(200.00)
                                        )
                                )
                        ),
                        new FloorGoodsVO(
                                2L,
                                "floor good 2",
                                List.of(
                                        new FloorGoodsDetailVO(
                                                3L,
                                                minioService.getUrlForDownload(MinioBucketEnum.HOME_BANNER.getCode(), "head.png"),
                                                "floor good 2 sub 1",
                                                BigDecimal.valueOf(300.00)
                                        ),
                                        new FloorGoodsDetailVO(
                                                4L,
                                                minioService.getUrlForDownload(MinioBucketEnum.HOME_BANNER.getCode(), "head.png"),
                                                "floor good 2 sub 2",
                                                BigDecimal.valueOf(400.00)
                                        )
                                )
                        )
                )
        );
    }
}
