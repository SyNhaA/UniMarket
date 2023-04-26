package co.edu.uniquindio.unimarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class CalificacionProductoGetDTO {

    private int id;

    private LocalDateTime fecha;

    private int puntuacion;

    private String comentario;

    private String codigoUsuario;

    private int codigoProducto;

}
