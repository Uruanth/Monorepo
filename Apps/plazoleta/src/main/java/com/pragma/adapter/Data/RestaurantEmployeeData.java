package com.pragma.adapter.Data;

import lombok.*;
import com.pragma.adapter.data.UserData;

import javax.persistence.*;

@Entity
@Table(name = "Restaurante_Empleado")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class RestaurantEmployeeData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_restaurante", referencedColumnName = "id_chef")
    private OrderData order;

    @ManyToOne
    @JoinColumn(name = "id_persona")
    private UserData user;

    @Column(name = "field")
    private String field;

}
