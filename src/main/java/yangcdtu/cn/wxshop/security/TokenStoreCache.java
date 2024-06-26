package yangcdtu.cn.wxshop.security;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import yangcdtu.cn.wxshop.common.cache.RedisCache;
import yangcdtu.cn.wxshop.common.cache.RedisKeys;

/**
 * 认证 Cache
 */
@Component
@AllArgsConstructor
@SuppressWarnings("unused")
public class TokenStoreCache {
    private final RedisCache redisCache;

    public void saveUser(String accessToken, UserDetail user) {
        String key = RedisKeys.getAccessTokenKey(accessToken);
        redisCache.set(key, user);
    }

    public UserDetail getUser(String accessToken) {
        String key = RedisKeys.getAccessTokenKey(accessToken);
        return (UserDetail) redisCache.get(key);
    }

    public void deleteUser(String accessToken) {
        String key = RedisKeys.getAccessTokenKey(accessToken);
        redisCache.delete(key);
    }
}
