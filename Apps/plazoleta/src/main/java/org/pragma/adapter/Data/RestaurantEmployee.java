package org.pragma.adapter.Data;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Restaurante_Empleado")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class RestaurantEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_restaurante")
    private Restaurant restaurant;
    @Column(name = "id_persona")
    private Integer id_person;
    @Column(name = "field")
    private String field;

}
