package com.pragma.usuario;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Rol{

    private Integer id;
    private String name;
    private String description;

}