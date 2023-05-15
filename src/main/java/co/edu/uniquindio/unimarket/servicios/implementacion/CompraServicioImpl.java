package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.CompraDTO;
import co.edu.uniquindio.unimarket.dto.CompraGetDTO;
import co.edu.uniquindio.unimarket.dto.DetalleCompraDTO;
import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.modelo.Compra;
import co.edu.uniquindio.unimarket.modelo.DetalleCompra;
import co.edu.uniquindio.unimarket.modelo.Producto;
import co.edu.uniquindio.unimarket.modelo.Usuario;
import co.edu.uniquindio.unimarket.repositorios.CompraRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.CompraServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CompraServicioImpl implements CompraServicio {

    private final CompraRepo compraRepo;
    private final UsuarioServicioImpl usuarioServicio;
    private final ProductoServicioImpl productoServicio;


    @Override
    public int crearCompra(CompraDTO compraDTO) throws Exception {

        if(compraDTO == null){
            throw new Exception("Porfavor verifique bien los datos");
        }
        Usuario usuario = usuarioServicio.obtenerUsuario(compraDTO.getCedulaUsuario());
        if(usuario == null){
            throw new Exception("El usuario no existe");
        }
        Compra compra = convertir_de_CompraDTO_a_Compra(compraDTO);
        compra.setUsuario(usuario);

        compraRepo.save(compra);
        return 0;
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

    @Override
    public double obtenerComprasSegunMesyAnio(Year anio, Month mes) throws Exception {

        if (anio == null || anio.getValue() <= 0) {
            throw new Exception("El año proporcionado no es válido");
        }

        if (mes == null || mes.getValue() < 1 || mes.getValue() > 12) {
            throw new Exception("El mes proporcionado no es válido");
        }

        YearMonth fechaActual = YearMonth.now();
        YearMonth fechaConsulta = YearMonth.of(anio.getValue(), mes);

        if (fechaConsulta.isAfter(fechaActual)) {
            throw new Exception("La fecha de consulta no puede ser posterior a la fecha actual.");
        }

        List<Compra> comprasSegunMesyAño = compraRepo.listaDeComprasSegunMesyFecha(anio.getValue(), mes.getValue());
        double total = 0;
        for (Compra compra:comprasSegunMesyAño) {
            total += compra.getTotal();
        }
        return total;
    }

    @Override
    public List<ProductoGetDTO> obtenerProductoCompradorPorUnUsuarioSinRepetir(String cedula) throws Exception {

        if (cedula == ""){
            throw new Exception("Por favor ingrese una cedula");
        }

        if (usuarioServicio.obtenerUsuario(cedula) == null){
            throw new Exception("El usuario no existe, valide bien los datos proporcionados");
        }

        List<Producto> listaProductos = compraRepo.listaDeProductoDeUnUsuarioSinRepetir(cedula);

        if (listaProductos.isEmpty()) {
            throw new Exception("El usuario no ha comprado ningún producto");
        }

        List<ProductoGetDTO> listaProductoGetDTO = new ArrayList<>();

        for (Producto producto : listaProductos) {
            listaProductoGetDTO.add(convertir_de_Producto_a_PruductoGetDTO(producto));
        }

        return listaProductoGetDTO;
    }

    private ProductoGetDTO convertir_de_Producto_a_PruductoGetDTO(Producto producto) {
        return null;
    }

    public Compra convertir_de_CompraDTO_a_Compra(CompraDTO compraDTO) throws Exception {
        Compra compra = new Compra();
        compra.setFechaCompra(LocalDateTime.now());
        compra.setTotal(compraDTO.getTotal());
        compra.setMedioPago(compraDTO.getMedioPago());

//        List<DetalleCompra> listaDetalleCompra = new ArrayList<>();
//
//        for (DetalleCompraDTO detalleCompraDTO : compraDTO.getDetalleCompraDTO()) {
//            listaDetalleCompra.add(convertir_de_DetalleCompraDTO_A_DetalleCompra(detalleCompraDTO));
//        }
//
//        compra.setListaDetalleCompras(listaDetalleCompra);

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
