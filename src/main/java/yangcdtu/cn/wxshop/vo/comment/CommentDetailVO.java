package yangcdtu.cn.wxshop.vo.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import yangcdtu.cn.wxshop.vo.auth.UserInfoVO;

import java.util.List;

@Data
@AllArgsConstructor
public class CommentDetailVO {
    private UserInfoVO userInfo;
    private String addTime;
    private String content;
    private List<String> picList;
    private String reply;
}
