package yangcdtu.cn.wxshop.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserInfoDTO {
    private String avatarUrl;
    private String city;
    private String country;
    private Integer gender;
    private String language;
    private String nickName;
    private String province;
}
