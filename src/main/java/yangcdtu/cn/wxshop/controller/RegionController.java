package yangcdtu.cn.wxshop.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yangcdtu.cn.wxshop.entity.Region;
import yangcdtu.cn.wxshop.service.RegionService;
import yangcdtu.cn.wxshop.vo.region.RegionVO;

import java.util.List;

@Tag(name = "区域")
@RestController
@RequestMapping("region")
@AllArgsConstructor
public class RegionController {
    private final RegionService regionService;
    @GetMapping("list")
    @Operation(summary = "列表")
    public List<RegionVO> getRegionList(@RequestParam Long pid){
        return regionService.list(
                new LambdaQueryWrapper<Region>()
                        .eq(Region::getPid, pid)
        ).stream().map(this::toRegionVO).toList();
    }

    private RegionVO toRegionVO(Region region) {
        return new RegionVO(region.getId(), region.getPid(), region.getName(), region.getType().getCode(), false);
    }
}
