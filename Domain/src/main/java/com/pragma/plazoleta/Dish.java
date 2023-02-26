package com.pragma.plazoleta;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder(toBuilder = true)
public class Dish {

    private Integer id;
    private String name;
    private Category category;
    private String description;
    private Float price;
    private Set<Restaurant> restaurants;
    private String url_image;
    private Boolean active;

}
