package co.edu.uniquindio.unimarket.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private int id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario vendedor;

    @OneToMany(mappedBy = "producto")
    private List<ProductoModerador> listaProductosModerador;

    @OneToMany(mappedBy = "producto")
    private List<Comentario> listaComentarios;

    @OneToMany(mappedBy = "producto")
    private List<DetalleCompra> listaDetalleCompras;

    @ElementCollection
    private List<String> listaImagenes;

    @OneToMany(mappedBy = "producto")
    private List<CalificacionProducto> listaCalificaciones;

    @ManyToMany(mappedBy = "productosFavoritos")
    private Set<Usuario> usuariosFavoritos = new HashSet<>();

    @Column(length = 100, nullable = false)
    private String nombre;

    @PositiveOrZero
    @Column(nullable = false)
    private int unidades;

    @Column(nullable = false, length = 300)
    private String descripcion;

    @PositiveOrZero
    @Column(nullable = false)
    private double precio;

    @Column(nullable = false)
    private boolean activo;

    @Column(nullable = false)
    private LocalDateTime fechaCreado;

    @Future
    @Column(nullable = false)
    private LocalDateTime fechaVencimiento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private Categoria categoria;

}
