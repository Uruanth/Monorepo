package com.pragma.adapter.Data;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Restaurante")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nombre")
    private String name;
    @Column(name = "direccion")
    private String addres;
    @Column(name = "id_propietario")
    private String id_owner;
    @Column(name = "telefono")
    private String phone;
    @Column(name = "urlLogo")
    private String urlLogo;
    @Column(name = "nit")
    private String nit;

}
