package co.edu.uniquindio.unimarket.modelo;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Email;

import java.io.Serializable;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(unique = true)
    private String cedula;

    @Column(length = 100)
    private String nombre;

    @Email
    @Column(length = 50, unique = true)
    private String email;

    @Column
    private String contraseña;
}
