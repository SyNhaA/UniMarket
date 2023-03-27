package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.entidades.MedioPago;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class CompraDTO {

    private int codigoUsuario;
    private MedioPago medioPago;
    private List<DetalleCompraDTO> detalleCompraDTO;
}
