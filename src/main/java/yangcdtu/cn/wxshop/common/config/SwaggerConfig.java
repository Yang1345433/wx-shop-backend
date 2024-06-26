package yangcdtu.cn.wxshop.common.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springdoc.core.customizers.GlobalOpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yangcdtu.cn.wxshop.security.PermitResource;

import java.util.Collections;
import java.util.Map;

@Configuration
@AllArgsConstructor
@SecurityScheme(
        type = SecuritySchemeType.APIKEY,
        in = SecuritySchemeIn.HEADER,
        name = "x-access-token"
)
public class SwaggerConfig {
    private final PermitResource permitResource;
    @Bean
    public OpenAPI customOpenAPI() {
        Contact contact = new Contact();
        contact.setName("杨建明");
        return new OpenAPI().security(Collections.singletonList(new SecurityRequirement().addList("x-access-token")))
                .info(
                        new Info().title("wx-shop")
                                .description("wx-shop")
                                .contact(contact)
                                .version("1.0.0")
                );
    }

    @Bean
    public GlobalOpenApiCustomizer globalOpenApiCustomizer() {
        return openApi -> {
            if (openApi.getPaths() != null) {
                for (Map.Entry<String, PathItem> entry : openApi.getPaths().entrySet()) {
                    String path = entry.getKey();
                    PathItem pathItem = entry.getValue();

                    // 排除不需要鉴权的path
                    if (permitResource.getPermitList().stream().anyMatch(permit -> {
                        if (permit.endsWith("/**")) {
                            return path.startsWith(permit.substring(0, permit.length() - 3));
                        } else {
                            return permit.equals(path);
                        }
                    })) {
                        continue;
                    }

                    // 接口添加鉴权参数
                    for (Operation operation : pathItem.readOperations()) {
                        operation.addSecurityItem(new SecurityRequirement().addList("x-access-token"));
                    }
                }
            }
        };
    }

}
