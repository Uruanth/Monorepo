package org.pragma.adapter.Data;

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

    @Column(name = "id_cliente")
    private Integer id_client;
    @Column(name = "fecha")
    private Date date;
    @Column(name = "estado")
    private String status;
    @Column(name = "id_chef")
    private Integer id_chef;
    @Column(name = "id_restaurante")
    private Integer id_restaurant;

    @OneToMany(mappedBy = "order")
    Set<OrderDish> number;

}
