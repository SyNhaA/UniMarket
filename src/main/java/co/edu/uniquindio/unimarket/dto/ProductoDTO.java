package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.modelo.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ProductoDTO {

    @NotBlank
    @NotNull
    @Length(max = 100, message = "El nombre debe tener máximo 100 caracteres")
    private String nombre;

    @NotBlank
    @NotNull
    @Length(max = 300, message = "La descripción debe tener máximo 300 caracteres")
    private String descripcion;

    @NotNull
    @NotBlank
    @PositiveOrZero(message = "Las unidades deben ser positivas")
    private int unidades;

    @NotNull
    @NotBlank
    @PositiveOrZero(message = "El precio debe ser positivo")
    private double precio;

    @NotNull
    @NotBlank
    private boolean activo;

    @NotNull
    @NotBlank
    @Length(max = 10, message = "El código del vendedor debe tener máximo 10 caracteres")
    private String cedulaVendedor;

    private List<ImagenDTO> imagenes;

    @NotNull
    @NotBlank
    @Length(max = 30, message = "La categoría debe tener máximo 50 caracteres")
    private Categoria categoria;

}
