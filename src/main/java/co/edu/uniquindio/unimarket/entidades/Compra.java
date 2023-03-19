package co.edu.uniquindio.unimarket.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Compra implements Serializable{

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @ManyToOne
    private Usuario usuario;

    @Column
    @OneToMany(mappedBy = "compra")
    private List<DetalleCompra> listaDetalleCompra;

    @Column(nullable = false)
    private LocalDate fechaCompra;

    @Column
    private double total;

    @Column
    @Enumerated(value = EnumType.STRING)
    private EstadoCompra estadoCompra;

    @Column
    @Enumerated(value = EnumType.STRING)
    private MedioPago medioPago;
}
