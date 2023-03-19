package co.edu.uniquindio.unimarket.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.awt.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Producto implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column
    private String codigo_vendedor;

    @Column
    @ManyToOne
    private Categoria categoria;


    @Column(length = 100, nullable = false)
    private String nombre;

    @Column
    private int unidades;

    @Column(length = 200)
    private String descripcion;

    @Positive
    @Column(nullable = false)
    private double precio;

    @Column(nullable = false)
    private boolean activo;

    @Column(nullable = false)
    private LocalDate fechaCreado;

    @Future
    @Column(nullable = false)
    private LocalDate fechaVencimiento;
}
