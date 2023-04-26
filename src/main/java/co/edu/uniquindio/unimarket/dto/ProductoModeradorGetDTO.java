package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.modelo.EstadoProducto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductoModeradorGetDTO {

    private int id;

    private String motivo;

    private EstadoProducto estadoProducto;

    private int idProducto;

    private String cedulaModerador;

    private LocalDateTime fecha;

}
