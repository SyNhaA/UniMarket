package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.ProductoDTO;
import co.edu.uniquindio.unimarket.modelo.Categoria;
import co.edu.uniquindio.unimarket.modelo.Producto;
import co.edu.uniquindio.unimarket.modelo.Usuario;
import co.edu.uniquindio.unimarket.repositorios.ProductoRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicioImpl implements ProductoServicio {

    private final ProductoRepo productoRepo;

    public ProductoServicioImpl(ProductoRepo productoRepo) {
        this.productoRepo = productoRepo;
    }

    @Override
    public void actualizarProducto(Producto producto, int idProducto) throws Exception {

    }

    @Override
    public int crearProducto(ProductoDTO productoDTO) {
        return 0;
    }

    @Override
    public int actualizarProducto(int codigoProducto, ProductoDTO productoDTO) throws Exception {
        return 0;
    }

    @Override
    public int actualizarUnidades(int codigoProducto, int unidades) throws Exception {
        return 0;
    }

    @Override
    public void eliminarProducto(int idProducto) throws Exception {

    }

    @Override
    public Producto obtenerProducto(int idProducto) throws Exception {
        return null;
    }

    @Override
    public List<Producto> listarProductos() {
        return null;
    }

    @Override
    public List<Producto> listarProductosPorNombre(String nombre) {
        return null;
    }

    @Override
    public List<Producto> listarProductosUsuario(int codigoUsuario) throws Exception {
        return null;
    }

    @Override
    public List<Producto> listarProductosPorCategoria(Categoria categoria) {
        return null;
    }

    @Override
    public List<Producto> listarProductosPorPrecio(double precioMinimo, double precioMaximo) {
        return null;
    }

    @Override
    public List<Producto> listarProductosPorNombreYCategorias(String nombre, Categoria categoria) {
        return null;
    }

    @Override
    public List<Producto> listarProductosPaginados(Pageable pageable) {
        return null;
    }

    @Override
    public Page<Producto> buscarProductosPaginados(String termino, Pageable pageable) {
        return null;
    }

    @Override
    public void aumentarVisitas(int idProducto) throws Exception {

    }

    @Override
    public List<Producto> listarProductosPorVendedor(String correo) {
        return null;
    }

    private Producto convertirDTO(ProductoDTO productoDTO) throws Exception{
        Producto producto = new Producto();
        Usuario usuario = new Usuario();
        producto.setNombre(productoDTO.getNombre());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setUnidades(productoDTO.getUnidades());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setActivo(true);

        //Seteamos vendedor(usuario)
        usuario.setCedula(productoDTO.getCedulaVendedor());

        producto.setCategoria(productoDTO.getCategoria());
        return producto;
    }
}
