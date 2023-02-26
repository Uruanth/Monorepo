package com.pragma.plazoleta;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Category {

    private Integer id;
    private String name;
    private String description;

}
