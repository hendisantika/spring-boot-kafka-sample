package id.my.hendisantika.kafkasample.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-kafka-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 6/12/24
 * Time: 17:27
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI notifOpenAPI(@Value("${application-description}") String appDescription, @Value("${application" +
            "-version}") String appVersion) {
        OpenAPI openAPI = new OpenAPI();
        openAPI.info(new io.swagger.v3.oas.models.info.Info()
                .title("Kafka Service API")
                .description(appDescription)
                .version(appVersion)
                .contact(new io.swagger.v3.oas.models.info.Contact()
                        .name("Hendi Santika")
                        .url("https://s.id/hendisantika")
                        .email("hendisantika@yahoo.co.id"))
                .termsOfService("TOC")
                .license(new io.swagger.v3.oas.models.info.License().name("License").url("https://s.id/hendisantika")));
        return openAPI;
    }
}
