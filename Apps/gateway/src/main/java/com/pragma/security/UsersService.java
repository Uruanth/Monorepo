package com.pragma.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Data
@Slf4j
@AllArgsConstructor
@Service
public class UsersService {
    private final JdbcTemplate jdbc;
    private final PasswordEncoder encoder;

    public Mono<SecurityUser> findByEmail(String email) {

        SecurityUser saveU = jdbc.query("SELECT * FROM usuarios WHERE correo = '" + email + "'",
                        (rs, rowNum) ->
                                SecurityUser.builder()
                                        .id(rs.getInt("id"))
                                        .username(rs.getString("nombre"))
                                        .rol("COM")
                                        .email(rs.getString("correo"))
                                        .password(rs.getString("clave"))
                                        .build()
                )
                .get(0);
        return Mono.just(saveU)
                .onErrorReturn(SecurityUser.builder()
                        .id(-1)
                        .username("unauthorized")
                        .rol("NONE")
                        .email("unauthorized@unauthorized.un.u")
                        .password("")
                        .build());
    }

}
