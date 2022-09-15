package com.example.rewardyourteachersq011bjavapode.security;
import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfig {
    @Value("${cloudinary_name}")
    private String cloudName;
    @Value("${cloudinary_api_key}")
    private String apiKey;
    @Value("${cloudinary_api_secret}")
    private String apiSecret;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public Cloudinary cloudinary(){
        Cloudinary cloudinary;
        Map<String, Object> config = new HashMap<>();
        config.put("cloud_name", cloudName);
        config.put("api_key", apiKey);
        config.put("api_secret", apiSecret);
        config.put("secure", true);
        cloudinary = new Cloudinary(config);
        return cloudinary;
    }

}
