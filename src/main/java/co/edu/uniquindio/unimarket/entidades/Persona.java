package co.edu.uniquindio.unimarket.entidades;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Email;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Persona implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String cedula;

    private Cuenta cuenta;

    @Column
    @Enumerated(value = EnumType.STRING)
    private TipoPersona tipoPersona;

    @Column(length = 100)
    private String nombre;

    @Email
    @Column(length = 50, unique = true)
    private String email;

    @Column(length = 10)
    private String telefono;

    @Column(length = 100)
    private String direccion;

    @Column
    @Enumerated(value = EnumType.STRING)
    private TipoGenero genero;



}
