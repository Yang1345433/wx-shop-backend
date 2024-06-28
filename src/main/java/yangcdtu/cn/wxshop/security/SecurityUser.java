package yangcdtu.cn.wxshop.security;

import org.springframework.security.core.context.SecurityContextHolder;

@SuppressWarnings("unused")
public class SecurityUser {
    public static UserDetail getUser() {
        return (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public static Long getUserId() {
        return getUser().getId();
    }
}
