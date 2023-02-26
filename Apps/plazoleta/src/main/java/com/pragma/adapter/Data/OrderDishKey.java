package com.pragma.adapter.Data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class OrderDishKey implements Serializable {

    @Column(name = "id_orden")
    private Integer id_order;

    @Column(name = "id_plato")
    private Integer id_dish;

}
