package yangcdtu.cn.wxshop.common.advance;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Enumeration;

@RestControllerAdvice
public class GlobalLoggingAdvice {
    private static final Logger logger = LoggerFactory.getLogger(GlobalLoggingAdvice.class);
    @ModelAttribute
    public void logRequestInfo(HttpServletRequest request) {
        if (request.getRequestURI().contains("swagger") || request.getRequestURI().contains("api-docs")) return ;

        logger.debug("Request URI: " + request.getRequestURI());
        logger.debug("Method: " + request.getMethod());

        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            logger.debug(paramName + ": " + request.getParameter(paramName));
        }
    }
}
