package yangcdtu.cn.wxshop.common.config;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinioConfig {
    @Value("${minio.auth.url}")
    private String url;
    @Value("${minio.auth.access-key}")
    private String accessKey;
    @Value("${minio.auth.secret-key}")
    private String secretKey;
    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint(url)
                .credentials(accessKey, secretKey)
                .build();
    }
}
