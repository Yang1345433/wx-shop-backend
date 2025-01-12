package yangcdtu.cn.wxshop.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import yangcdtu.cn.wxshop.entity.User;
import yangcdtu.cn.wxshop.enums.RoleEnum;

import java.util.List;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void insertUserTest() {
        User user = User.builder()
                .name("杨建明")
                .phone("18357894352")
                .password(passwordEncoder.encode("123456"))
                .roles(List.of(RoleEnum.ADMIN, RoleEnum.BUSINESS, RoleEnum.GUEST))
                .build();

        userService.save(user);

        System.out.println(user);
    }

    @Test
    public void pageTest() {
        Page<User> page = userService.page(
                Page.of(1, 10),
                new LambdaQueryWrapper<User>()
                        .eq(User::getName, "杨建明")
        );

        System.out.println(page.getTotal());
        System.out.println(page.getRecords());
    }

    @Test
    public void getUser() {
        User user = userService.getById(1L);

        System.out.println(user);
    }
}
