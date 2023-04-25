package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.modelo.EstadoProducto;
import co.edu.uniquindio.unimarket.modelo.ProductoModerador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProductoModeradorRepo extends JpaRepository<ProductoModerador, Integer> {

    // Query para buscar un producto por su estado
    ProductoModerador findByEstadoProducto(EstadoProducto estadoProducto);

    // Query para listar los productos de un moderador, por pagina
    @Query("select pm from ProductoModerador pm where pm.moderador.email = :correo")
    List<ProductoModerador> listarProductosModerador(String correo, Pageable paginador);

    // Query para listar los productos aprobados entre dos fechas
    @Query("select pm from ProductoModerador pm where pm.estadoProducto = 'APROBADO' and pm.fecha between :fechaInicio and :fechaFin")
    List<ProductoModerador> listarProductosAprobadosEntreFechas(LocalDate fechaInicio, LocalDate fechaFin);

    // Query para listar los productos rechazados entre dos fechas
    @Query("select pm from ProductoModerador pm where pm.estadoProducto = 'RECHAZADO' and pm.fecha between :fechaInicio and :fechaFin")
    List<ProductoModerador> listarProductosRechazadosEntreFechas(LocalDate fechaInicio, LocalDate fechaFin);

    // Query para listar los productos por estado
    @Query("select pm from ProductoModerador pm where pm.estadoProducto = :estado")
    List<ProductoModerador> listarProductosPorEstado(EstadoProducto estado);

}
