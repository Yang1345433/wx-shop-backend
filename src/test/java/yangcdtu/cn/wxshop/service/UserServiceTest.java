package yangcdtu.cn.wxshop.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import yangcdtu.cn.wxshop.entity.User;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void insertUserTest() {
        User user = User.builder()
                .name("杨建明")
                .phone("18357894352")
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
}
