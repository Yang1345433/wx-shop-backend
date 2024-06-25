package yangcdtu.cn.wxshop.common.cache;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RedisCacheTest {
    @Autowired
    private RedisCache redisCache;
    @Test
    public void setTest() {
        redisCache.set("key", "value");
    }

    @Test
    public void getTest() {
        Object obj = redisCache.get("key");

        System.out.println(obj);
    }
}
