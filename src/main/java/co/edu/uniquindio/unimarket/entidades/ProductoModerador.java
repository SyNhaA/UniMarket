package co.edu.uniquindio.unimarket.entidades;

import co.edu.uniquindio.unimarket.entidades.Estado;
import co.edu.uniquindio.unimarket.entidades.Moderador;
import co.edu.uniquindio.unimarket.entidades.Producto;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @Enumerated(value = EnumType.STRING)
    private Estado estado;

    @ManyToOne
    private Moderador moderador;

    @ManyToOne
    private Producto producto;

    @Lob
    @Column(nullable = false)
    private String motivo;

    @Column(nullable = false)
    private LocalDateTime fecha;
}
