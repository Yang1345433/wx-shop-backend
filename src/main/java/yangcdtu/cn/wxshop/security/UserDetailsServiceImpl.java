package yangcdtu.cn.wxshop.security;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import yangcdtu.cn.wxshop.common.exception.ServerException;
import yangcdtu.cn.wxshop.entity.User;
import yangcdtu.cn.wxshop.service.UserService;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getOne(
                new LambdaQueryWrapper<User>()
                        .eq(User::getPhone, username)
        );

        if (user == null) throw new ServerException("无此账号");

        return user.toUserDetail();
    }
}
