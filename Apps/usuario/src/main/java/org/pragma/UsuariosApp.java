package org.pragma;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UsuariosApp {
    public static void main(String[] args) {
        System.out.println("Usuarios");
        SpringApplication.run(UsuariosApp.class);
    }
}