package co.edu.uniquindio.unimarket.entidades;

import co.edu.uniquindio.unimarket.entidades.Estado;
import co.edu.uniquindio.unimarket.entidades.Moderador;
import co.edu.uniquindio.unimarket.entidades.Producto;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class ProductoModerador implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @Enumerated(value = EnumType.STRING)
    private Estado estado;

    @Column
    @ManyToOne
    private Moderador moderador;

    @Column
    @ManyToOne
    private Producto producto;

    @Column
    private String motivo;

    @Column
    private Date fecha;
}
