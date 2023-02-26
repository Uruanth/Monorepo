package org.pragma.adapter.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "microservice.jdbc")
@Getter
@Setter
public class JdbcProperties {

    private String driverClassName;
    private String url;
    private String userName;
    private String password;


}
