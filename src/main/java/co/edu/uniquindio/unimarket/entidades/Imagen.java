package co.edu.uniquindio.unimarket.entidades;

import jakarta.persistence.*;

import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Imagen implements Serializable {

    @Id
    @Column
    private int id;

    @ManyToOne
    private Producto producto;
}
