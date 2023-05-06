package com.pragma.usuario;

import lombok.*;

import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String lastName;
    private String mobile;
    private String email;
    private String pass;

    private Rol rol;

}
