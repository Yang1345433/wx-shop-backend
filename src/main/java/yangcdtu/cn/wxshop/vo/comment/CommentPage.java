package yangcdtu.cn.wxshop.vo.comment;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CommentPage {
    private Long currentPage;
    private List<CommentDetailVO> data;
}
