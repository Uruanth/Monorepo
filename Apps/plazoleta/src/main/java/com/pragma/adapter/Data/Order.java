package com.pragma.adapter.Data;

import com.pragma.adapter.data.User;
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
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cliente")
    private User user_id;
    @Column(name = "fecha")
    private Date date;
    @Column(name = "estado")
    private String status;
    @Column(name = "id_chef")
    private Integer id_chef;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_restaurante")
    private Restaurant restaurant;

    @OneToMany(mappedBy = "order")
    Set<OrderDish> number;

}
