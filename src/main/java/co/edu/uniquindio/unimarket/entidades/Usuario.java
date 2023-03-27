package co.edu.uniquindio.unimarket.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Usuario extends Persona implements Serializable {

    @OneToMany(mappedBy = "usuario")
    private List<Comentario> listaComentario;

    @OneToMany(mappedBy = "usuario")
    private List<Compra> listaCompras;

    @OneToMany(mappedBy = "usuario")
    private List<Favorito> listaFavorito;

    @OneToMany(mappedBy = "usuario")
    private List<Producto> listaProducto;

    @Column
    private String direccion;

    @Column
    private String telefono;

}
