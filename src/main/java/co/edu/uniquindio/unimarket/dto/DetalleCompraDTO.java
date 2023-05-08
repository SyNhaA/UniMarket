package co.edu.uniquindio.unimarket.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class DetalleCompraDTO {

    public DetalleCompraDTO() {

    }

    @NotNull
    @NotBlank
    @Positive(message = "El código del producto debe ser positivo")
    private int codigoProducto;

    @NotNull
    @NotBlank
    @Positive(message = "El código de la compra debe ser positivo")
    private int codigoCompra;

    @NotNull
    @NotBlank
    @PositiveOrZero(message = "Las unidades deben ser positivas")
    private int unidades;

    @NotNull
    @NotBlank
    @PositiveOrZero(message = "El precio debe ser positivo")
    private double precio;


}
