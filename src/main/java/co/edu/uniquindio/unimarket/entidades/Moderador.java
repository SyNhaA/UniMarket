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
public class Moderador extends Persona implements Serializable{

    @OneToMany(mappedBy = "moderador")
    private List<ProductoModerador> listaProductoModerador;

}
