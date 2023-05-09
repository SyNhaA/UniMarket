package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.ProductoDTO;
import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.modelo.Categoria;
import co.edu.uniquindio.unimarket.modelo.Producto;
import co.edu.uniquindio.unimarket.modelo.Usuario;
import co.edu.uniquindio.unimarket.repositorios.ProductoRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductoServicioImpl implements ProductoServicio {

    private final ProductoRepo productoRepo;

    @Override
    public void actualizarProducto(Producto producto) throws Exception {
        validarExistenciaProducto(producto.getId());
        productoRepo.save(producto);
    }

    @Override
    public int crearProducto(ProductoDTO productoDTO) throws Exception {
        Producto producto = convertir_de_ProductoDTO_a_Producto(productoDTO);

        validarExistenciaProducto(producto.getId());

        producto.setFechaCreado(LocalDateTime.now());
        productoRepo.save(producto);
        return 0;
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
    public void eliminarProducto(int idProducto) throws Exception {
        validarExistenciaProducto(idProducto);
        productoRepo.deleteById(idProducto);
    }

    @Override
    public Producto obtenerProducto(int idProducto) throws Exception {
        Optional<Producto> producto = productoRepo.findById(idProducto);

        if(producto.isEmpty() )
        {
            throw new Exception("El código "+idProducto+" no está asociado a ningún producto");
        }

        return producto.get();
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

    public boolean validarExistenciaProducto(Integer idProducto){
        return true;
    }

    public Producto convertir_de_ProductoDTO_a_Producto(ProductoDTO productoDTO) throws Exception{
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

    public ProductoGetDTO convertir_de_Producto_a_ProductoDTO(Producto producto){
        return null;
    }

}
