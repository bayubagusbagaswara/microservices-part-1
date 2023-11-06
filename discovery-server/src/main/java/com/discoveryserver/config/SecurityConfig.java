package com.discoveryserver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // masih menggunakan configuration security lama
    @Value("${eureka.username}")
    private String username;

    @Value("${eureka.password}")
    private String password;
}
