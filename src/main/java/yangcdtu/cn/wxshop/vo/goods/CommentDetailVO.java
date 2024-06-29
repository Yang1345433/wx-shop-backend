package yangcdtu.cn.wxshop.vo.goods;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CommentDetailVO {
    private String avatar;
    private String nickname;
    private String addTime;
    private String content;
    private List<String> picList;
}
