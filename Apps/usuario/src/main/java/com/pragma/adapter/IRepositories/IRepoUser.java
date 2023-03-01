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
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Component
@AllArgsConstructor
public class IRepoUser implements UserRepo {

    private final JdbcTemplate jdbc;
    private final String QUERY_SAVE_USER = new StringBuilder()
            .append("INSERT INTO ")
            .append("usuarios (correo, apellido, celular, nombre, clave, id_rol) ")
            .append("VALUES (?,?,?,?,?,?,?)")
            .toString();

    @Override
    public Mono<User> saveUser(User user) {
        jdbc.update(QUERY_SAVE_USER,
                user.getEmail(),
                user.getLastName(),
                user.getMobile(),
                user.getName(),
                user.getPass(),
                RolEnum.ADMIN.getCode()
        );

        UserData saveU = Optional.of(jdbc.query(getQueryUserByEmail(user.getEmail()),
                        (rs, rowNum) -> {
                            var rol = getRol(rs);
                            return this.buildUserData(rs, rol);
                        })).orElseThrow(() -> new RuntimeException("error al guardar el usuario"))
                .get(0);

        return Mono.just(User.builder()
                .id(saveU.getId())
                .name(saveU.getName())
                .pass(saveU.getPassword())
                .lastName(saveU.getLastName())
                .mobile(saveU.getMobile())
                .email(saveU.getEmail())
                .roles(Collections.emptyList())
                .build());
    }

    private static RolData getRol(ResultSet rs) {
        var list = Arrays.stream(RolEnum.values())
                .filter(rolEnum -> {
                    try {
                        return rolEnum.getTipo().equals(rs.getString("rol"));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList());

        return getRolData(list);
    }

    private static RolData getRolData(List<RolEnum> list) {
        if (!list.isEmpty()) {
            return RolData.builder()
                    .description(list.get(0).getTipo())
                    .name(list.get(0).getTipo())
                    .id(list.get(0).getCode())
                    .build();
        } else {
            return getRolUnauthorized();
        }
    }

    private static RolData getRolUnauthorized() {
        return RolData.builder()
                .id(RolEnum.UNAUTHORIZED.getCode())
                .description(RolEnum.UNAUTHORIZED.getTipo())
                .name(RolEnum.UNAUTHORIZED.getTipo())
                .build();
    }

    private UserData buildUserData(ResultSet rs, RolData rol) {
        try {
            return UserData.builder()
                    .id(rs.getInt("id"))
                    .roles(rol)
                    .name(rs.getString("nombre"))
                    .email(rs.getString("correo"))
                    .lastName(rs.getString("apellido"))
                    .mobile(rs.getString("celular"))
                    .password(rs.getString("clave"))
                    .build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private String getQueryUserByEmail(String email) {
        return "select u.id, u.nombre, u.correo, u.apellido, u.celular, u.clave, (\n" +
                "    SELECT descripcion from roles r where r.id = u.id_rol\n" +
                "    ) as rol from usuarios u WHERE u.correo = '" + email + "'";
    }
}
