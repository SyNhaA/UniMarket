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
public class ComentarioGetDTO {

    private int codigo;

    private LocalDateTime fecha;

    private String mensaje;

    private String codigoUsuario;

    private int codigoProducto;

}
