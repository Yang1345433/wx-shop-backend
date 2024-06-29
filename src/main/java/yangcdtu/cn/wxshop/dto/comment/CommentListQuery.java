package yangcdtu.cn.wxshop.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommentListQuery {
    private Long valueId;
    private Integer type;
    private Long size;
    private Long page;
    private Integer showType;
}
