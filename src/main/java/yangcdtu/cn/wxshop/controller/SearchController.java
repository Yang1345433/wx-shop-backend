package yangcdtu.cn.wxshop.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yangcdtu.cn.wxshop.vo.search.KeywordVO;
import yangcdtu.cn.wxshop.vo.search.SearchIndexVO;

import java.util.List;

@Tag(name = "搜索")
@RestController
@RequestMapping("search")
@AllArgsConstructor
public class SearchController {
    @GetMapping("index")
    @Operation(summary = "首页")
    public SearchIndexVO getSearchIndexKeyword() {
        return new SearchIndexVO(
                List.of(
                        new KeywordVO("history keyword 1"),
                        new KeywordVO("history keyword 2")
                ),
                new KeywordVO("default keyword"),
                List.of(
                        new KeywordVO("hot keyword 1"),
                        new KeywordVO("hot keyword 2")
                )
        );
    }

    @GetMapping("helper")
    @Operation(summary = "帮助")
    public List<String> getSearchHelperList(@RequestParam String keyword) {
        return List.of(
                keyword,
                "helper 1",
                "helper 2",
                "helper 3"
        );
    }
}
