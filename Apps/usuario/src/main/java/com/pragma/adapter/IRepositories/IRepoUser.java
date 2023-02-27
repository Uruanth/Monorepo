package com.pragma.adapter.IRepositories;

import com.pragma.RolEnum;
import com.pragma.adapter.config.SpringJdbcConfig;
import com.pragma.adapter.data.RolData;
import com.pragma.adapter.data.UserData;
import com.pragma.usecases.repositories.UserRepo;
import com.pragma.usuario.Rol;
import com.pragma.usuario.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Slf4j
@Component
@AllArgsConstructor
public class IRepoUser implements UserRepo {

    private final JdbcTemplate jdbc;

    @Override
    public Mono<User> saveUser(User user) {

        String uuidNewUser = UUID.randomUUID().toString();

        String query = new StringBuilder()
                .append("INSERT INTO ")
                .append("usuarios (uuid, correo, apellido, celular, nombre, clave, id_rol) ")
                .append("VALUES (?,?,?,?,?,?,?)")
                .toString();

        int result = jdbc.update(query,
                uuidNewUser,
                user.getEmail(),
                user.getLastName(),
                user.getMobile(),
                user.getName(),
                user.getPass(),
                RolEnum.ADMIN.getCode()
        );

        log.info("se guardo -> " + result);
        UserData saveU = jdbc.query("SELECT * FROM usuarios WHERE uuid = '" + uuidNewUser + "'",
                        (rs, rowNum) -> {
//                            RolData rol = jdbc.query(
//                                            "SELECT * FROM roles WHERE id = " + rs.getInt("id_rol"),
//                                            (rs1, rowNum1) -> RolData.builder()
//                                                    .id(rs1.getInt("id"))
//                                                    .name(rs1.getString("nombre"))
//                                                    .description(rs1.getString("descripcion"))
//                                                    .build())
//                                    .get(0);

                            return UserData.builder()
                                    .id(rs.getInt("id"))
                                    .uuid(rs.getString("uuid"))
                                    .roles(RolData.builder().build())
                                    .name(rs.getString("nombre"))
                                    .email(rs.getString("correo"))
                                    .lastName(rs.getString("apellido"))
                                    .mobile(rs.getString("celular"))
                                    .password(rs.getString("clave"))
                                    .build();
                        })
                .get(0);


        return Mono.just(User.builder()
                .id(saveU.getId())
                .uuid(saveU.getUuid())
                .name(saveU.getName())
                .pass(saveU.getPassword())
                .lastName(saveU.getLastName())
                .mobile(saveU.getMobile())
                .email(saveU.getEmail())
//                .roles(
//                        List.of(Rol.builder()
//                                .id(saveU.getRoles().getId())
//                                .name(saveU.getRoles().getName())
//                                .description(saveU.getRoles().getDescription())
//                                .build()
//                        )
//                )
                .roles(Collections.emptyList())
                .build());
    }
}
