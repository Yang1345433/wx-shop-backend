package yangcdtu.cn.wxshop.vo.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserInfoVO {
    private String avatarUrl;
    private String nickName;
    private Long userId;
    private int userLevel;
    private String userLevelDesc;
    private String registerDate;
    private String phone;
}
