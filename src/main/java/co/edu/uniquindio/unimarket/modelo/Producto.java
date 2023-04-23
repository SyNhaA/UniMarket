package co.edu.uniquindio.unimarket.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

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

    @ManyToOne
    private Usuario usuario;

    @OneToMany(mappedBy = "producto")
    private List<ProductoModerador> listaProductoModerador;

    @OneToMany(mappedBy = "producto")
    private List<Comentario> listaComentario;

    @OneToMany(mappedBy = "producto")
    private List<Favorito> listaFavorito;

    @OneToMany(mappedBy = "producto")
    private List<DetalleCompra> listaDetalleCompra;

    @OneToMany(mappedBy = "producto")
    private List<Categoria> listaCategorias;

    @OneToMany(mappedBy = "producto")
    private List<Imagen> listaImagenes;

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
    private LocalDateTime fechaCreado;

    @Future
    @Column(nullable = false)
    private LocalDateTime fechaVencimiento;

    private EstadoProducto estadoProducto;
}
