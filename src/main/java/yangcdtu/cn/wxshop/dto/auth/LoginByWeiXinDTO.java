package yangcdtu.cn.wxshop.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginByWeiXinDTO {
    private String code;
    private UserInfoDTO UserInfo;
    private Long shareUserId;
}
