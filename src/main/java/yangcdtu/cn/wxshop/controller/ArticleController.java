package yangcdtu.cn.wxshop.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yangcdtu.cn.wxshop.vo.article.ArticleDetailVO;

@Tag(name = "公告")
@RestController
@RequestMapping("article")
@AllArgsConstructor
public class ArticleController {
    @GetMapping("detail")
    @Operation(summary = "信息")
    public ArticleDetailVO getArticleDetail(@RequestParam Long id) {
        return new ArticleDetailVO("test" + id, "正式内容", "2024-06-28", 1);
    }
}
