package yangcdtu.cn.wxshop.common.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        Contact contact = new Contact();
        contact.setName("杨建明");
        return new OpenAPI().info(
                new Info().title("wx-shop")
                        .description("wx-shop")
                        .contact(contact)
                        .version("1.0.0")
        );
    }
}
