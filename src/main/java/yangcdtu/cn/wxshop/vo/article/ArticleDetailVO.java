package yangcdtu.cn.wxshop.vo.article;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArticleDetailVO {
    private String title;
    private String content;
    private String addTime;
    private Integer type;
}
