package yangcdtu.cn.wxshop.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import yangcdtu.cn.wxshop.enums.RoleEnum;

import java.util.List;

@SpringBootTest
public class TokenStoreCacheTest {
    @Autowired
    private TokenStoreCache tokenStoreCache;

    @Test
    public void testForSaveUser() {
        String token = TokenUtils.generator();
        System.out.println(token);
        tokenStoreCache.saveUser(
                token,
                new UserDetail(1L, "杨建明", "18357894352", "123456", List.of(RoleEnum.ADMIN))
        );
    }

    @Test
    public void testForGetUser() {
        String token = TokenUtils.generator();
        System.out.println(token);
        tokenStoreCache.saveUser(
                token,
                new UserDetail(1L, "杨建明", "18357894352", "123456", List.of(RoleEnum.ADMIN))
        );

        UserDetail user = tokenStoreCache.getUser(token);
        System.out.println(user);
    }
}
