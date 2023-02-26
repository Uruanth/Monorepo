package com.pragma.adapter.Data;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Pedido_Platos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class OrderDish {

    @EmbeddedId
    OrderDishKey id;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "id_orden")
    private Order order;

    @ManyToOne
    @MapsId("dishId")
    @JoinColumn(name = "id_plato")
    private Dish dish;

    @Column(name = "cantidad")
    private Integer number;

}
