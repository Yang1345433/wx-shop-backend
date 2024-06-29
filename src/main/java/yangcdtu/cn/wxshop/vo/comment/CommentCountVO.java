package yangcdtu.cn.wxshop.vo.comment;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommentCountVO {
    private Long allCount;
    private Long hasPicCount;
}
