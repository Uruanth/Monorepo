package com.pragma.adapter.Data;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "categoria")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CategoryData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "descripcion")
    private String description;

}
