package yangcdtu.cn.wxshop.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommentCountQuery {
    private Long valueId;
    private Integer type;
}
