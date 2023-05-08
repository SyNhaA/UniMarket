package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.CompraGetDTO;
import co.edu.uniquindio.unimarket.dto.DetalleCompraDTO;
import co.edu.uniquindio.unimarket.dto.DetalleCompraGetDTO;
import co.edu.uniquindio.unimarket.modelo.DetalleCompra;
import co.edu.uniquindio.unimarket.repositorios.DetalleCompraRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.DetalleCompraService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DetalleCompraImpl implements DetalleCompraService {

    private final DetalleCompraRepo detalleCompraRepo;
    private final CompraServicioImpl compraServicio;


    @Override
    public List<DetalleCompraDTO> listarPorCodigoProducto(Integer codigo) throws Exception {

        List<DetalleCompra> detallesCompra = detalleCompraRepo.listarDetallesProducto(codigo);
        List<DetalleCompraDTO> detalleCompraDTOS = new ArrayList<>();

        for (DetalleCompra detalle: detallesCompra) {
            detalleCompraDTOS.add(compraServicio.convertir_de_DealleCompra_a_DetalleCompraDTO(detalle));
        }

        return detalleCompraDTOS;
    }

}
