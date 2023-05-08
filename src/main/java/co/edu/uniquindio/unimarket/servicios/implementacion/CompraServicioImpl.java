package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.CompraDTO;
import co.edu.uniquindio.unimarket.dto.CompraGetDTO;
import co.edu.uniquindio.unimarket.dto.DetalleCompraDTO;
import co.edu.uniquindio.unimarket.modelo.Compra;
import co.edu.uniquindio.unimarket.modelo.DetalleCompra;
import co.edu.uniquindio.unimarket.repositorios.CompraRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.CompraServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CompraServicioImpl implements CompraServicio {

    private final CompraRepo compraRepo;
    private final UsuarioServicioImpl usuarioServicio;
    private final DetalleCompraImpl detalleCompraServicio;
    private final ProductoServicioImpl productoServicio;


    @Override
    public int crearCompra(CompraDTO compraDTO) throws Exception {

        Compra compra = convertir_de_CompraDTO_a_Compra(compraDTO);

        return compraRepo.save(compra).getId();
    }

    @Override
    public List<CompraGetDTO> listarCompras(String codigoUsuario) {

        List<Compra> listarCompras = compraRepo.listarComprasUsuarioPorCedula(codigoUsuario);
        List<CompraGetDTO> listaComprasGetDTO = new ArrayList<>();

        for (Compra compra : listarCompras) {
            listaComprasGetDTO.add(covertir_de_Compra_a_CompraDTO(compra));
        }

        return listaComprasGetDTO;
    }


    @Override
    public CompraGetDTO obtenerCompra(int codigoCompra) {
        Optional<Compra> compra = compraRepo.findById(codigoCompra);
        CompraGetDTO compraGetDTO = covertir_de_Compra_a_CompraDTO(compra.get());

        return compraGetDTO;
    }

    public Compra convertir_de_CompraDTO_a_Compra(CompraDTO compraDTO) throws Exception {
        Compra compra = new Compra();
        compra.setFechaCompra(LocalDateTime.now());
        compra.setTotal(compraDTO.getTotal());
        compra.setMedioPago(compraDTO.getMedioPago());
        compra.setUsuario(usuarioServicio.obtenerUsuario(compraDTO.getCedulaUsuario()));

        List<DetalleCompra> listaDetalleCompra = new ArrayList<>();

        for (DetalleCompraDTO detalleCompraDTO : compraDTO.getDetalleCompraDTO()) {
            listaDetalleCompra.add(convertir_de_DetalleCompraDTO_A_DetalleCompra(detalleCompraDTO));
        }

        compra.setListaDetalleCompras(listaDetalleCompra);

        return compra;
    }


    public CompraGetDTO covertir_de_Compra_a_CompraDTO(Compra compra) {
        CompraGetDTO compraGetDTO = new CompraGetDTO();
        List<DetalleCompraDTO> listaDetalleCompraDTO = new ArrayList<>();

        compraGetDTO.setId(compra.getId());
        compraGetDTO.setFecha(compra.getFechaCompra());
        compraGetDTO.setValorTotal(compra.getTotal());
        compraGetDTO.setCodigoUsuario(compra.getUsuario().getCedula());
        compraGetDTO.setMedioPago(compra.getMedioPago());

        for (DetalleCompra detalleCompra : compra.getListaDetalleCompras()) {
            listaDetalleCompraDTO.add(convertir_de_DealleCompra_a_DetalleCompraDTO(detalleCompra));
        }

        compraGetDTO.setDetalleCompraDTO(listaDetalleCompraDTO);

        return compraGetDTO;
    }

    public DetalleCompraDTO convertir_de_DealleCompra_a_DetalleCompraDTO(DetalleCompra detalleCompra) {

        DetalleCompraDTO detalleCompraDTO = new DetalleCompraDTO();

        detalleCompraDTO.setCodigoProducto(detalleCompra.getProducto().getId());
        detalleCompraDTO.setCodigoCompra(detalleCompra.getCompra().getId());
        detalleCompraDTO.setUnidades(detalleCompra.getUnidades());
        detalleCompraDTO.setPrecio(detalleCompra.getPrecioProducto());

        return detalleCompraDTO;
    }

    public DetalleCompra convertir_de_DetalleCompraDTO_A_DetalleCompra(DetalleCompraDTO detalleCompraDTO) throws Exception {

        DetalleCompra detalleCompra = new DetalleCompra();
        Optional<Compra> compra = compraRepo.findById(detalleCompraDTO.getCodigoCompra());

        detalleCompra.setProducto(productoServicio.obtenerProducto(detalleCompraDTO.getCodigoProducto()));
        detalleCompra.setCompra(compra.get());
        detalleCompra.setUnidades(detalleCompraDTO.getUnidades());
        detalleCompra.setPrecioProducto(detalleCompraDTO.getPrecio());

        return detalleCompra;
    }

}
