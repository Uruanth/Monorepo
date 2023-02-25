package org.pragma.adapter.Data;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "plato")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nombre")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_categoria")
    private Category category;

    @Column(name = "descripcion")
    private String description;
    @Column(name = "precio")
    private Float price;

    @ManyToOne
    @JoinColumn(name = "id_restaurante")
    private Restaurant restaurant;
    @Column(name = "url_imagen")
    private String url_image;
    @Column(name = "activo")
    private Boolean available;

    @OneToMany(mappedBy = "dish")
    Set<OrderDish> number;

}
