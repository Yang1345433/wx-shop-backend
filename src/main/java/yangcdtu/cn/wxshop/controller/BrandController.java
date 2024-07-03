package yangcdtu.cn.wxshop.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yangcdtu.cn.wxshop.dto.brand.BrandPageQuery;
import yangcdtu.cn.wxshop.service.BrandService;
import yangcdtu.cn.wxshop.vo.brand.BrandDetailVO;
import yangcdtu.cn.wxshop.vo.brand.BrandPage;

@Tag(name = "品牌")
@RestController
@RequestMapping("brand")
@AllArgsConstructor
public class BrandController {
    private final BrandService brandService;

    @GetMapping("detail")
    @Operation(summary = "信息")
    public BrandDetailVO getBrandDetail(@RequestParam Long id) {
        return brandService.getDetail(id);
    }

    @GetMapping("list")
    @Operation(summary = "列表")
    public BrandPage getBrandList(@ParameterObject BrandPageQuery query) {
        return brandService.getBrandList(query);
    }
}
