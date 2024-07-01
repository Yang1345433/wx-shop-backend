package yangcdtu.cn.wxshop.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import yangcdtu.cn.wxshop.entity.Article;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class ArticleServiceTest {
    @Autowired
    private ArticleService articleService;

    @Test
    public void saveArticles() {
        List<Article> articles = List.of(
                new Article(
                        null,
                        "关于xxx的公告",
                        "关于xxx公告的内容",
                        LocalDate.now().toString(),
                        1
                ),
                new Article(
                        null,
                        "关于xxx的新闻",
                        "关于xxx新闻的内容",
                        LocalDate.now().toString(),
                        2
                )
        );

        articleService.saveBatch(articles);
    }
}
