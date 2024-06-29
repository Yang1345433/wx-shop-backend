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
import yangcdtu.cn.wxshop.vo.brand.BrandDetailVO;

@Tag(name = "品牌")
@RestController
@RequestMapping("brand")
@AllArgsConstructor
public class BrandController {
    private final MinioService minioService;

    @GetMapping("detail")
    @Operation(summary = "信息")
    public BrandDetailVO getBrandDetail(@RequestParam Long id) {
        System.out.println(id);
        return new BrandDetailVO("brand name 1", minioService.getUrlForDownload(MinioBucketEnum.HOME_BANNER.getCode(), "head.png"));
    }
}
