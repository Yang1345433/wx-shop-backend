package yangcdtu.cn.wxshop.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yangcdtu.cn.wxshop.common.utils.MinioService;
import yangcdtu.cn.wxshop.enums.MinioBucketEnum;
import yangcdtu.cn.wxshop.vo.home.BannerVO;
import yangcdtu.cn.wxshop.vo.home.ChannelVO;
import yangcdtu.cn.wxshop.vo.home.HomeIndexInfoVO;

import java.util.List;

@Tag(name = "首页")
@RestController
@RequestMapping("home")
@AllArgsConstructor
public class IndexController {
    private final MinioService minioService;
    @GetMapping("index")
    @Operation(summary = "数据")
    public HomeIndexInfoVO homeIndexInfo() {
        return new HomeIndexInfoVO(
                minioService.getObjectsNameByBucket(MinioBucketEnum.HOME_BANNER.getCode()).stream().map(
                        item -> new BannerVO(minioService.getUrlForDownload(MinioBucketEnum.HOME_BANNER.getCode(), item))
                ).toList(),
                List.of(
                        new ChannelVO(
                                1L,
                                minioService.getUrlForDownload(MinioBucketEnum.HOME_CHANNEL.getCode(), "dfh.png"),
                                "火车"
                        )
                )
        );
    }
}
