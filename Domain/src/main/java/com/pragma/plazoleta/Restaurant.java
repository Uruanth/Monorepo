package com.pragma.plazoleta;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Restaurant {

    private Integer id;
    private String name;
    private String addres;
    private String id_owner;
    private String phone;
    private String urlLogo;
    private Integer nit;

}
