package com.pragma;

import lombok.Getter;

@Getter
public  enum RolEnum {
    ADMIN("ADMINISTRADOR", 1),
    OWNER("PROPIETARIO", 2),
    EMPLOYEE("EMPLOYEE", 3),
    CLIENT("CLIENTE", 4);
    private final String tipo;
    private final Integer code;

    RolEnum(String tipo, Integer code) {
        this.tipo = tipo;
        this.code = code;
    }
}