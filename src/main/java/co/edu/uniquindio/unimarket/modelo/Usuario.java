package co.edu.uniquindio.unimarket.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Usuario extends Persona implements Serializable {

    @OneToMany(mappedBy = "usuario")
    private List<Comentario> listaComentarios;

    @OneToMany(mappedBy = "usuario")
    private List<Compra> listaCompras;

    @OneToMany(mappedBy = "vendedor")
    private List<Producto> listaProductos;

    @OneToMany(mappedBy = "usuario")
    private List<Calificacion> listaCalificaciones;

    @ManyToMany
    @JoinTable(
            name = "favoritos",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    private Set<Producto> productosFavoritos = new HashSet<>();

    @Column(length = 100, nullable = false)
    private String direccion;

    @Column(length = 10)
    private String telefono;

}
