package yangcdtu.cn.wxshop.security;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import jakarta.servlet.http.HttpServletRequest;

/**
 * Token 工具类
 */
@SuppressWarnings("unused")
public class TokenUtils {

    public static final String X_ACCESS_TOKEN = "x-access-token";
    public static final String ACCESS_TOKEN = "access_token";

    /**
     * 生成 AccessToken
     */
    public static String generator() {
        return UUID.fastUUID().toString(true);
    }

    /**
     * 获取 AccessToken
     */
    public static String getAccessToken(HttpServletRequest request) {
        String accessToken = request.getHeader(X_ACCESS_TOKEN);
        if (StrUtil.isBlank(accessToken)) {
            accessToken = request.getParameter(ACCESS_TOKEN);
        }

        return accessToken;
    }
}
