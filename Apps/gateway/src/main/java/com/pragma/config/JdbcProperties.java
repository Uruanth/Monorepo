package com.pragma.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "microservice.jdbc")
@Data
public class JdbcProperties {

    private String driverClassName;
    private String url;
    private String userName;
    private String password;


}
