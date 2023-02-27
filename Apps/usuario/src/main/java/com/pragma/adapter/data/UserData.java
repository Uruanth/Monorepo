package com.pragma.adapter.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "uuid", unique = true)
    private String uuid;

    @Column(name = "nombre")
    private String name;

    @Column(name = "apellido")
    private String lastName;
    @Column(name = "celular")
    private String mobile;
    @Column(name = "correo")
    private String email;
    @Column(name = "clave")
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_rol", referencedColumnName = "id")
    private RolData roles;

}
