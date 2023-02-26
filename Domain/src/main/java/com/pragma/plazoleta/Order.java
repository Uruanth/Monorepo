package com.pragma.plazoleta;

import com.pragma.usuario.User;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Data
@Builder(toBuilder = true)
public class Order {

    private Integer id;
    private User client;
    private User chef;
    private LocalDate date;
    private String status;
    private Restaurant restaurant;
    private Map<Dish, Integer> dishNumber;

}
