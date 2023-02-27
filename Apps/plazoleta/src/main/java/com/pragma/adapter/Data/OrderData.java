package com.pragma.adapter.Data;

import com.pragma.adapter.data.UserData;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Pedido")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class OrderData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cliente")
    private UserData user_id;
    @Column(name = "fecha")
    private Date date;
    @Column(name = "estado")
    private String status;
    @Column(name = "id_chef")
    private Integer id_chef;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_restaurante")
    private RestaurantData restaurant;

    @OneToMany(mappedBy = "order")
    Set<OrderDishData> number;

}
