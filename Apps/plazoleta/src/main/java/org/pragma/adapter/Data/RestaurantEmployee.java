package org.pragma.adapter.Data;

import lombok.*;
import org.pragma.adapter.data.User;

import javax.persistence.*;
import java.util.Set;

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

    @OneToMany
    @JoinColumn(name = "id_persona")
    private Set<User> user;
    
    @Column(name = "field")
    private String field;

}
