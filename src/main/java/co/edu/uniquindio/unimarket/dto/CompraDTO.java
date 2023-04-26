package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.modelo.MedioPago;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class CompraDTO {

    @NotNull
    @NotBlank
    @Length(max = 10, message = "La cédula debe tener máximo 10 caracteres")
    private String cedulaUsuario;

    @NotNull
    @NotBlank
    @Length(max = 50, message = "El medio de pago debe tener máximo 50 caracteres")
    private MedioPago medioPago;

    private List<DetalleCompraDTO> detalleCompraDTO;
}
