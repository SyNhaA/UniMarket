package co.edu.uniquindio.unimarket.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Favorito {

    @Id
    @ManyToOne
    private Producto producto;

    @Id
    @ManyToOne
    private Usuario usuario;
}
