package org.pragma.adapter.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

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
    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol roles;

}
