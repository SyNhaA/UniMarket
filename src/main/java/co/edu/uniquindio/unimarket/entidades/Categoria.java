package co.edu.uniquindio.unimarket.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Categoria {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;
}
