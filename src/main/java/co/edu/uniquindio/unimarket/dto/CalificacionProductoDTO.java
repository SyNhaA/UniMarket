package co.edu.uniquindio.unimarket.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@Getter
@Setter
public class CalificacionProductoDTO {

    @NotNull
    @NotBlank
    @Min(value = 1, message = "La puntuacion debe ser mayor o igual a 1")
    @Max(value = 5, message = "La puntuacion debe ser menor o igual a 5")
    @Length(max = 1, message = "La puntuacion debe tener solo 1 caracter")
    private int puntacion;

    @Length(max = 200, message = "El comentario debe tener máximo 200 caracteres")
    private String comentario;

    @NotNull
    @NotBlank
    @Length(max = 10, message = "La cédula debe tener máximo 10 caracteres")
    private String cedulaUsuario;

    @NotNull
    @NotBlank
    @Positive(message = "El id del producto debe ser positivo")
    private int idProducto;

}
