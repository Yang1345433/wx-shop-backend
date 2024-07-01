package yangcdtu.cn.wxshop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import yangcdtu.cn.wxshop.vo.article.ArticleDetailVO;
import yangcdtu.cn.wxshop.vo.article.ArticlesVO;

@TableName("article")
@Data
@AllArgsConstructor
public class Article {
    private Long id;
    private String title;
    private String content;
    private String addTime;
    private Integer type;

    public ArticleDetailVO toDetailVO() {
        return new ArticleDetailVO(
                title,
                content,
                addTime,
                type
        );
    }

    public ArticlesVO toVO() {
        return new ArticlesVO(
                id,
                title
        );
    }
}
