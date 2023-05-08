package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.ProductoDTO;
import co.edu.uniquindio.unimarket.modelo.Categoria;
import co.edu.uniquindio.unimarket.modelo.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductoServicio {

    int crearProducto(ProductoDTO productoDTO) throws Exception;

    void actualizarProducto(Producto producto) throws Exception;

    int actualizarUnidades(int codigoProducto, int unidades) throws Exception;

    void eliminarProducto(int idProducto) throws Exception;

    Producto obtenerProducto(int idProducto) throws Exception;

    List<Producto> listarProductos();

    List<Producto> listarProductosPorNombre(String nombre);

    List<Producto> listarProductosUsuario(int codigoUsuario) throws Exception;

    List<Producto> listarProductosPorCategoria(Categoria categoria);

    List<Producto> listarProductosPorPrecio(double precioMinimo, double precioMaximo);

    List<Producto> listarProductosPorNombreYCategorias(String nombre, Categoria categoria);

    List<Producto> listarProductosPaginados(Pageable pageable);

    Page<Producto> buscarProductosPaginados(String termino, Pageable pageable);

    void aumentarVisitas(int idProducto) throws Exception;

    List<Producto> listarProductosPorVendedor(String correo);

}
