package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.modelo.MedioPago;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class CompraGetDTO {

    private int id;

    private LocalDateTime fecha;

    private double valorTotal;

    private String codigoUsuario;

    private MedioPago medioPago;

    private List<DetalleCompraDTO> detalleCompraDTO;

}
