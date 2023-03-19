package co.edu.uniquindio.unimarket.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Venta implements Serializable{

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Cuenta cuenta;

    @Column(length = 200)
    private String descripcion;

    @Column(nullable = false)
    private LocalDate fechaVenta;

    @Column
    private double total;

    @Column
    @Enumerated(value = EnumType.STRING)
    private EstadoVenta estadoVenta;
}
