package yangcdtu.cn.wxshop.common.advance;

import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import yangcdtu.cn.wxshop.common.utils.JsonUtils;
import yangcdtu.cn.wxshop.common.utils.Result;

/**
 * 全局返回类型设置，不支持String类型封装
 */
@RestControllerAdvice
public class ResultBodyAdvance implements ResponseBodyAdvice<Object> {
     private static final Logger logger = LoggerFactory.getLogger(ResultBodyAdvance.class);
    @Override
    public boolean supports(@NotNull MethodParameter returnType, @NotNull Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, @NotNull MethodParameter returnType, @NotNull MediaType selectedContentType, @NotNull Class<? extends HttpMessageConverter<?>> selectedConverterType, @NotNull ServerHttpRequest request, @NotNull ServerHttpResponse response) {
        String requestUrl = request.getURI().getPath();

        // swagger文档内容全部直接放行
        if (requestUrl.contains("swagger") || requestUrl.contains("api-docs")) {
            return body;
        }

        // Result类型不用再次封装
        if (returnType.getParameterType().isAssignableFrom(Result.class)) {
            logger.debug(JsonUtils.toJsonString(body));
            return body;
        }
        // String类型不支持，返回原String
        else if (returnType.getParameterType().isAssignableFrom(String.class)) {
            return body;
        }

        logger.debug(JsonUtils.toJsonString(Result.ok(body)));
        return Result.ok(body);
    }
}
