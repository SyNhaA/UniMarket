package co.edu.uniquindio.unimarket.entidades;

import jakarta.persistence.*;
import lombok.*;
import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Comentario implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @ManyToOne
    private Usuario usuario;

    @Column
    @ManyToOne
    private Producto producto;

    @Column
    private String mensaje;

    @Column
    private Date fechaCreacion;
}
