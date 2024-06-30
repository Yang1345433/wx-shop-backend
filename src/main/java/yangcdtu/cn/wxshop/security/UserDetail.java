package yangcdtu.cn.wxshop.security;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import yangcdtu.cn.wxshop.enums.RoleEnum;
import yangcdtu.cn.wxshop.enums.UserLevelEnum;
import yangcdtu.cn.wxshop.vo.auth.UserInfoVO;

import java.io.Serial;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
@Data
@NoArgsConstructor
@SuppressWarnings("unused")
public class UserDetail implements UserDetails {
    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String username;
    private String password;
    private List<RoleEnum> roles;
    /**
     * 帐户是否过期
     */
    private boolean isAccountNonExpired = true;
    /**
     * 帐户是否被锁定
     */
    private boolean isAccountNonLocked = true;
    /**
     * 密码是否过期
     */
    private boolean isCredentialsNonExpired = true;
    /**
     * 帐户是否可用
     */
    private boolean isEnabled = true;

    public UserDetail(Long id, String name, String username, String password, List<RoleEnum> roles) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public void setAuthorities(Collection<Authority> collection) {
        roles = collection.stream().map(it -> RoleEnum.valueOf(it.getAuthority())).toList();
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(it -> new Authority(it.toString())).collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public UserInfoVO toUserInfoVO(
            String avatarUrl
    ) {
        return new UserInfoVO(
                avatarUrl,
                this.name,
                this.getId(),
                UserLevelEnum.LEVEL_1.getCode(),
                UserLevelEnum.LEVEL_1.getDesc(),
                LocalDate.now().toString(),
                this.username
        );
    }
}
