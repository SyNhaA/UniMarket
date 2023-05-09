package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.CompraGetDTO;
import co.edu.uniquindio.unimarket.dto.DetalleCompraDTO;
import co.edu.uniquindio.unimarket.dto.DetalleCompraGetDTO;
import co.edu.uniquindio.unimarket.modelo.DetalleCompra;
import co.edu.uniquindio.unimarket.repositorios.DetalleCompraRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.DetalleCompraService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DetalleCompraImpl implements DetalleCompraService {

    private final DetalleCompraRepo detalleCompraRepo;

    public DetalleCompraImpl(DetalleCompraRepo detalleCompraRepo) {
        this.detalleCompraRepo = detalleCompraRepo;
    }


    @Override
    public List<DetalleCompraDTO> listarPorCodigoProducto(Integer codigo) throws Exception {

        List<DetalleCompra> detallesCompra = detalleCompraRepo.listarDetallesProducto(codigo);
        List<DetalleCompraDTO> detalleCompraDTOS = new ArrayList<>();

        for (DetalleCompra detalle: detallesCompra) {
            detalleCompraDTOS.add(convertir_de_DealleCompra_a_DetalleCompraDTO(detalle));
        }

        return detalleCompraDTOS;
    }

    public DetalleCompraDTO convertir_de_DealleCompra_a_DetalleCompraDTO(DetalleCompra detalleCompra) {

        DetalleCompraDTO detalleCompraDTO = new DetalleCompraDTO();

        detalleCompraDTO.setCodigoProducto(detalleCompra.getProducto().getId());
        detalleCompraDTO.setCodigoCompra(detalleCompra.getCompra().getId());
        detalleCompraDTO.setUnidades(detalleCompra.getUnidades());
        detalleCompraDTO.setPrecio(detalleCompra.getPrecioProducto());

        return detalleCompraDTO;
    }

}
