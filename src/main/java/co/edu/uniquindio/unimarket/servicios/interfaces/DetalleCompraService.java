package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.CompraGetDTO;
import co.edu.uniquindio.unimarket.dto.DetalleCompraDTO;
import co.edu.uniquindio.unimarket.dto.DetalleCompraGetDTO;
import co.edu.uniquindio.unimarket.modelo.DetalleCompra;

import java.util.List;

public interface DetalleCompraService {

    List<DetalleCompraDTO> listarPorCodigoProducto(Integer codigo) throws Exception;
}
