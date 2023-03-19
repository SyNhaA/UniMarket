package co.edu.uniquindio.unimarket.entidades;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Email;

import java.io.Serializable;
import java.net.PasswordAuthentication;

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

    @Column(length = 100)
    private String nombre;

    @Email
    @Column(length = 50, unique = true)
    private String email;

    @Column
    private String contraseña;
}
