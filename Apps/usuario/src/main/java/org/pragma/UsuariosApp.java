package org.pragma;


import org.pragma.adapter.config.JdbcProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UsuariosApp {
    @Autowired
    private static JdbcProperties jdbcConfig;

    public static void main(String[] args) {
        SpringApplication.run(UsuariosApp.class);
    }
}