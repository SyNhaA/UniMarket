package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.modelo.EstadoProducto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@Getter
@Setter
public class ProductoModeradorDTO {

    @NotNull
    @NotBlank
    private String motivo;

    @NotNull
    @NotBlank
    @Length(max = 20, message = "El estado debe tener máximo 20 caracteres")
    private EstadoProducto estadoProducto;

    @NotNull
    @NotBlank
    @Positive(message = "El id del producto debe ser positivo")
    private int idProducto;

    @NotNull
    @NotBlank
    @Length(max = 10, message = "La cédula del moderador debe tener máximo 10 caracteres")
    private String cedulaModerador;

}
