package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.ProductoDTO;
import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.modelo.Categoria;
import co.edu.uniquindio.unimarket.modelo.Producto;
import co.edu.uniquindio.unimarket.repositorios.ProductoRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicioImpl implements ProductoServicio {

    @Override
    public Producto registrarProducto(Producto producto) {
        return null;
    }

    @Override
    public void actualizarProducto(Producto producto, int idProducto) throws Exception {

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
}
