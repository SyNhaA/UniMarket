package co.edu.uniquindio.unimarket.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class ComentarioDTO {

    @NotNull
    @NotBlank
    @Length(max = 200, message = "El mensaje debe tener máximo 200 caracteres")
    private String mensaje;

    @NotNull
    @NotBlank
    @Length(max = 10, message = "La cedula del usuario debe tener máximo 10 caracteres")
    private String cedulaUsuario;

    @NotNull
    @NotBlank
    @Positive(message = "El codigo del producto debe ser positivo")
    private int codigoProducto;

    private LocalDateTime fechaCreacion;

}
