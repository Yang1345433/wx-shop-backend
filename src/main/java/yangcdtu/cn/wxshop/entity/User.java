package yangcdtu.cn.wxshop.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import yangcdtu.cn.wxshop.Handler.RoleEnumListHandler;
import yangcdtu.cn.wxshop.enums.RoleEnum;
import yangcdtu.cn.wxshop.security.UserDetail;

import java.util.List;

@TableName("user")
@Data
@Builder
public class User {
    private Long id;
    private String name;
    private String phone;
    private String password;
    @TableField(typeHandler = RoleEnumListHandler.class)
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
}
