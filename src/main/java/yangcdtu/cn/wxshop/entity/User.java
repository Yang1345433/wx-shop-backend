package yangcdtu.cn.wxshop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import yangcdtu.cn.wxshop.enums.RoleEnum;
import yangcdtu.cn.wxshop.enums.UserLevelEnum;
import yangcdtu.cn.wxshop.security.UserDetail;
import yangcdtu.cn.wxshop.vo.auth.UserInfoVO;

import java.time.LocalDate;
import java.util.List;

@TableName("user")
@Data
@Builder
public class User {
    private Long id;
    private String openId;
    private String avatarUrl;
    private String name;
    private String phone;
    private String password;
    private List<RoleEnum> roles;

    public UserDetail toUserDetail() {
        return new UserDetail(
                id,
                name,
                phone,
                password,
                roles
        );
    }

    public UserInfoVO toUserInfoVO() {
        return new UserInfoVO(
                this.avatarUrl,
                this.name,
                this.id,
                UserLevelEnum.LEVEL_1.getCode(),
                UserLevelEnum.LEVEL_1.getDesc(),
                LocalDate.now().toString(),
                this.phone
        );
    }
}
