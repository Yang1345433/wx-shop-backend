package yangcdtu.cn.wxshop.dto.auth;

import lombok.Data;

@Data
public class LoginByPasswordDTO {
    private String phone;
    private String password;
}
