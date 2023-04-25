package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.ProductoDTO;
import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.modelo.Categoria;
import co.edu.uniquindio.unimarket.repositorios.ProductoRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicioImpl implements ProductoServicio {

    private final ProductoRepo productoRepo;

    public ProductoServicioImpl(ProductoRepo productoRepo) {

        this.productoRepo = productoRepo;
    }


    @Override
    public int crearProducto(ProductoDTO productoDTO) throws Exception {
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
    public int eliminarProducto(int codigoProducto) throws Exception {
        return 0;
    }

    @Override
    public ProductoGetDTO obtenerProducto(int codigoProducto) throws Exception {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosUsuario(int codigoUsuario) throws Exception {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosCategoria(Categoria categoria) throws Exception {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosFavoritos(int codigoUsuario) throws Exception {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosNombre(String nombre) throws Exception {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosPrecio(float precioMinimo, float precioMaximo) throws Exception {
        return null;
    }
}
