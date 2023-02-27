package com.pragma.security;

import com.pragma.defaultsBean.PassEncoder;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
@AllArgsConstructor
public class WebSecurityConfig {
    @Bean
    public SecurityWebFilterChain filterChain(
            ServerHttpSecurity http,
            ReactiveAuthenticationManager authManager,
            CorsConfigurationSource corsSourse
    ) {
        return http.
                csrf(ServerHttpSecurity.CsrfSpec::disable)
                .cors().configurationSource(corsSourse)
                .and()
                .authenticationManager(authManager)
                .authorizeExchange()
                .pathMatchers("/usuario/helpy").hasAuthority("ROLE_COM")
                .anyExchange()
                .authenticated()
                .and()
                .httpBasic()
                .and().build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration(
                "/**",
                new CorsConfiguration().applyPermitDefaultValues()
        );
        return source;
    }

    @Bean
    public ReactiveUserDetailsService userDetailsService(UsersService service) {
        return username -> service.findByEmail(username)
                .map(user -> User.withUsername(user.getUsername())
                        .password(user.getPassword())
                        .roles(user.getRol())
                        .build()
                );
    }

    @Bean
    public ReactiveAuthenticationManager authManager(ReactiveUserDetailsService userDetailsService,
                                                     PasswordEncoder passwordEncoder) {
        var authenticationManager = new UserDetailsRepositoryReactiveAuthenticationManager(userDetailsService);
        authenticationManager.setPasswordEncoder(passwordEncoder);
        return authenticationManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PassEncoder();
    }

}
