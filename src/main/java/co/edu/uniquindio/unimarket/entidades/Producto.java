package co.edu.uniquindio.unimarket.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Positive;
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
public class Producto implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column
    @ManyToOne
    private Usuario suario;

    @Column
    @OneToMany(mappedBy = "producto")
    private List<ProductoModerador> listaProductoModerador;

    @Column
    @OneToMany(mappedBy = "producto")
    private List<Comentario> listaComentario;

    @Column
    @OneToMany(mappedBy = "producto")
    private List<Favorito> listaFavorito;

    @Column
    @OneToMany(mappedBy = "producto")
    private List<DetalleCompra> listaDetalleCompra;

    @Column
    @OneToMany(mappedBy = "producto")
    private List<Categoria> listaCategorias;

    @Column
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
    private LocalDate fechaCreado;

    @Future
    @Column(nullable = false)
    private LocalDate fechaVencimiento;
}
