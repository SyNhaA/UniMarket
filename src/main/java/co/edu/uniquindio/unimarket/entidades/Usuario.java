package co.edu.uniquindio.unimarket.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Usuario extends Persona implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @OneToMany(mappedBy = "usuario")
    private List<Comentario> listaComentario;

    @Column
    @OneToMany(mappedBy = "usuario")
    private List<Compra> listaCompras;

    @Column
    @OneToMany(mappedBy = "usuario")
    private List<Favorito> listaFavorito;

    @Column
    @OneToMany(mappedBy = "usuario")
    private List<Producto> listaProducto;
    @Column
    private String direccion;

    @Column
    private String telefono;

}
