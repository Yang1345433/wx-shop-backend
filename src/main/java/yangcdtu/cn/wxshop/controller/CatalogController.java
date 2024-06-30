package yangcdtu.cn.wxshop.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yangcdtu.cn.wxshop.common.utils.MinioService;
import yangcdtu.cn.wxshop.enums.MinioBucketEnum;
import yangcdtu.cn.wxshop.vo.catalog.*;

import java.util.List;

@Tag(name = "分类")
@RestController
@RequestMapping("catalog")
@AllArgsConstructor
public class CatalogController {
    private final MinioService minioService;
    @GetMapping("index")
    @Operation(summary = "全部")
    public CatalogIndexVO getCatalogIndex() {
        return new CatalogIndexVO(
                List.of(
                        new CategoryVO(
                                1L,
                                "category 1"
                        ),
                        new CategoryVO(
                                2L,
                                "category 2"
                        ),
                        new CategoryVO(
                                3L,
                                "category 3"
                        )
                ),
                new CurrentCategoryVO(
                        1L,
                        minioService.getUrlForDownload(MinioBucketEnum.HOME_BANNER.getCode(), "head.png"),
                        "category1 front name",
                        "category 1"
                ),
                List.of(
                        new SubCategoryVO(
                                4L,
                                minioService.getUrlForDownload(MinioBucketEnum.HOME_BANNER.getCode(), "head.png"),
                                "sub category 1"
                        ),
                        new SubCategoryVO(
                                5L,
                                minioService.getUrlForDownload(MinioBucketEnum.HOME_BANNER.getCode(), "head.png"),
                                "sub category 2"
                        )
                )
        );
    }

    @GetMapping("current")
    @Operation(summary = "当前")
    public CatalogCurrentVO getCurrentCatalog(@RequestParam Long id) {
        System.out.println(id);
        return new CatalogCurrentVO(
                new CurrentCategoryVO(
                        id,
                        minioService.getUrlForDownload(MinioBucketEnum.HOME_BANNER.getCode(), "head.png"),
                        "category " + id + " front name",
                        "category " + id
                ),
                List.of(
                        new SubCategoryVO(
                                4L,
                                minioService.getUrlForDownload(MinioBucketEnum.HOME_BANNER.getCode(), "head.png"),
                                "sub category 3"
                        ),
                        new SubCategoryVO(
                                5L,
                                minioService.getUrlForDownload(MinioBucketEnum.HOME_BANNER.getCode(), "head.png"),
                                "sub category 4"
                        )
                )
        );
    }
}
