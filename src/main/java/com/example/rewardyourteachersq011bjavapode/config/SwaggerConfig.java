package com.example.rewardyourteachersq011bjavapode.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "springdoc.swagger-ui.enabled", havingValue = "true", matchIfMissing = true)
public class SwaggerConfig {
    @Value("REWARD YOUR TEACHER")
    private String title;
    @Value("")
    private String description;
    @Value("")
    private String version;
    @Value("")
    private String termsOfService;
    @Value("")
    private String contactName;
    @Value("")
    private String contactEmail;
    @Value("")
    private String contactUrl;
    @Value("")
    private String licenseUrl;
    @Value("")
    private String licenseName;

    @Bean
    public OpenAPI userAPI(){
        return new OpenAPI()
                .info(getInfoApi());

    }

    private Info getInfoApi(){
        Contact contact = new Contact().name(contactName).email(contactEmail).url(contactUrl);
        License license = new License().name(licenseName).url(licenseUrl);
        return new Info()
                .title(title)
                .description(description)
                .termsOfService(termsOfService)
                .version(version)
                .contact(contact)
                .license(license);
    }


}
