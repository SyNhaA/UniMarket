package co.edu.uniquindio.unimarket.dto;

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
public class ImagenDTO {

    @NotNull
    @NotBlank
    @Length(max = 200, message = "La url debe tener máximo 200 caracteres")
    private String url;

    @NotNull
    @NotBlank
    @Positive(message = "El código del producto debe ser positivo")
    private int codigoProducto;

}
