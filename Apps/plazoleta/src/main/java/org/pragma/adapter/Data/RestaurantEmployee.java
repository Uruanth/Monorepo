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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_restaurante", referencedColumnName = "id_chef")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "id_persona")
    private User user;

    @Column(name = "field")
    private String field;

}
