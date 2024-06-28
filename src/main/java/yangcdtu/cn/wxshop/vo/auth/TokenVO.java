package yangcdtu.cn.wxshop.vo.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TokenVO {
    private String accessToken;
    private UserInfoVO userInfo;
}
