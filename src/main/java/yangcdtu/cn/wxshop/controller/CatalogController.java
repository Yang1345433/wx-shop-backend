package yangcdtu.cn.wxshop.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yangcdtu.cn.wxshop.service.CategoryService;
import yangcdtu.cn.wxshop.vo.catalog.CatalogCurrentVO;
import yangcdtu.cn.wxshop.vo.catalog.CatalogIndexVO;

@Tag(name = "分类")
@RestController
@RequestMapping("catalog")
@AllArgsConstructor
public class CatalogController {
    private final CategoryService categoryService;
    @GetMapping("index")
    @Operation(summary = "全部")
    public CatalogIndexVO getCatalogIndex() {
        return categoryService.getCatalogIndex();
    }

    @GetMapping("current")
    @Operation(summary = "当前")
    public CatalogCurrentVO getCurrentCatalog(@RequestParam Long id) {
        return categoryService.getCurrentCatalog(id);
    }
}
