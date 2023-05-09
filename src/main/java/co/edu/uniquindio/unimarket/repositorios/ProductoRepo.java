package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.modelo.Categoria;
import co.edu.uniquindio.unimarket.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@Repository
public interface ProductoRepo extends JpaRepository<Producto, Integer> {

    // Query para listar los productos activos por pagina y ordenados por un atributo especifico
    @Query("select p from Producto p where p.activo = true")
    List<Producto> listarProductos(Pageable paginador);

    // Query para listar los productos por vendedor
    @Query("select p from Producto p where p.vendedor.email = :correo")
    List<Producto> listarProductosVendedor(String correo);

    // Query para listar los productos por categoria y por pagina, y ordenados por un atributo especifico
    @Query("select p from Producto p where p.categoria = :categoria and p.activo = true")
    List<Producto> listarProductosCategoria(Categoria categoria, Pageable paginador);

    // Query para listar los productos por nombre y por pagina, y ordenados por un atributo especifico
    @Query("select p from Producto p where p.nombre like concat( '%', :nombre, '%' ) and p.activo = true")
    List<Producto> listarProductosNombre(String nombre, Pageable paginador);

    // Query para listar los productos por nombre, categoria y por pagina, y ordenados por un atributo especifico
    @Query("select p from Producto p where p.nombre like concat( '%', :nombre, '%' ) and p.categoria = :categoria and p.activo = true")
    List<Producto> listarProductosNombreCategoria(String nombre, Categoria categoria, Pageable paginador);

    // Query para listar los productos por precio y por pagina, y ordenados por un atributo especifico
    @Query("select p from Producto p where p.precio between :precioMinimo and :precioMaximo and p.activo = true")
    List<Producto> listarProductosPrecio(double precioMinimo, double precioMaximo, Pageable paginador);

    // Query para listar los productos por precio, categoria y por pagina, y ordenados por un atributo especifico
    @Query("select p from Producto p where p.precio between :precioMinimo and :precioMaximo and p.categoria = :categoria and p.activo = true")
    List<Producto> listarProductosPrecioCategoria(double precioMinimo, double precioMaximo, Categoria categoria, Pageable paginador);

}
