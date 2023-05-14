package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.ProductoDTO;
import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.modelo.Categoria;
import co.edu.uniquindio.unimarket.modelo.Producto;
import co.edu.uniquindio.unimarket.modelo.Usuario;
import co.edu.uniquindio.unimarket.repositorios.ProductoRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductoServicioImpl implements ProductoServicio {

    private final ProductoRepo productoRepo;
    private final UsuarioServicioImpl usuarioServicio;

    @Override
    public Producto crearProducto(ProductoDTO productoDTO) throws Exception {

        if(productoDTO ==  null){
            new Exception("Producto null, por favor ingrese todos los datos");
        }

        Usuario usuario = usuarioServicio.obtenerUsuario(productoDTO.getCedulaVendedor());
        if (usuario ==  null){
            new Exception("El usuario no es valido, revise bien el valor");
        }

        Producto producto = convertirDeProductoDTOAProducto(productoDTO);
        producto.setVendedor(usuario);

        //ACTIVAR SOLO PARA EL TEST
        //producto.setId(12);

        producto.setFechaCreado(LocalDateTime.now());
        productoRepo.save(producto);

        return producto;
    }

    @Override
    public Producto actualizarProducto(Producto producto) throws Exception {
        validarExistenciaProducto(producto.getId());
        return productoRepo.save(producto);

    }

    @Override
    public int actualizarUnidades(int codigoProducto, int unidades) throws Exception {

        validarExistenciaProducto(codigoProducto);

        if (unidades<0)
        {
            throw new Exception("Las unidades no pueden ser menores a 0");
        }

        Producto producto = obtenerProducto(codigoProducto);
        producto.setUnidades(unidades);

        return productoRepo.save(producto).getId();
    }

    @Override
    public int eliminarProducto(int idProducto) throws Exception {
        validarExistenciaProducto(idProducto);
        productoRepo.deleteById(idProducto);
        return 0;
    }

    @Override
    public Producto obtenerProducto(int idProducto) throws Exception {

        if(idProducto < 0 ){
            throw  new Exception("El codigo es invalido");
        }

        Producto producto = productoRepo.findById(idProducto).orElse(null);
        if(producto == null)
        {
            throw new Exception("El producto no existe porfavor verifique el codigo");
        }

        return producto;
    }

    @Override
    public List<Producto> listarProductos() {

        return productoRepo.listarProductos(Pageable.ofSize(10));
    }

    @Override
    public List<Producto> listarProductosPorNombre(String nombre) {
        return productoRepo.listarProductosNombre(nombre,Pageable.ofSize(10));
    }

    @Override
    public List<Producto> listarProductosUsuario(String correo) throws Exception {
        return productoRepo.listarProductosVendedor(correo);
    }

    @Override
    public List<Producto> listarProductosPorCategoria(Categoria categoria) {

        return productoRepo.listarProductosCategoria(categoria, Pageable.ofSize(10));
    }

    @Override
    public List<ProductoGetDTO> productoMasCaroYMasBarato(Categoria categoria) throws Exception {

        if(categoria == null){
            throw new Exception("Por favor ingrese una categoria");
        }

        List<ProductoGetDTO> listaProductoCaroyBarato = new ArrayList<>();


        Producto productoCaro = productoRepo.obtenerProductoMasCaroCategoria(categoria);
        Producto productoBarato = productoRepo.obtenerProductoMasBaratoCategoria(categoria);

        listaProductoCaroyBarato.add(convertirDeProductoAProductoGetDTO(productoCaro));
        listaProductoCaroyBarato.add(convertirDeProductoAProductoGetDTO(productoBarato));

        return listaProductoCaroyBarato;
    }

    public boolean validarExistenciaProducto(Integer idProducto){
        if (productoRepo.existsById(idProducto)){
            return true;
        }
        return false;
    }

    private ProductoGetDTO convertirDeProductoAProductoGetDTO(Producto producto) {
        ProductoGetDTO productoGetDTO = new ProductoGetDTO(
                producto.getId(),
                producto.isActivo(),
                producto.getFechaCreado(),
                producto.getFechaVencimiento(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getUnidades(),
                producto.getPrecio(),
                producto.getVendedor().getCedula(),
                producto.getListaImagenes(),
                producto.getCategoria()
        );

        if (producto != null){
            return productoGetDTO;
        }else {
            return null;
        }
    }

    public Producto convertirDeProductoDTOAProducto(ProductoDTO productoDTO) throws Exception{

        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setFechaVencimiento(productoDTO.getFechaVencimiento());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setUnidades(productoDTO.getUnidades());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setActivo(true);
        producto.setCategoria(productoDTO.getCategoria());

        return producto;
    }

    public ProductoGetDTO convertir_de_Producto_a_ProductoDTO(Producto producto){
        ProductoGetDTO productoGetDTO = new ProductoGetDTO(
                producto.getId(),
                producto.isActivo(),
                producto.getFechaCreado(),
                producto.getFechaVencimiento(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getUnidades(),
                producto.getPrecio(),
                producto.getVendedor().getCedula(),
                producto.getListaImagenes(),
                producto.getCategoria()
        );
        return productoGetDTO;
    }

}
