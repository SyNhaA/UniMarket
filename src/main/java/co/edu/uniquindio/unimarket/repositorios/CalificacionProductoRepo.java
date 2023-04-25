package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.modelo.CalificacionProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalificacionProductoRepo extends JpaRepository<CalificacionProducto, Integer> {

    // Query para listar las calificaciones de un producto
    @Query("select c from CalificacionProducto c where c.producto.id = :id")
    List<CalificacionProducto> listarCalificacionesProducto(int id);

    // Query para obtener la calificacion de un producto hecha por un usuario especifico
    @Query("select c from CalificacionProducto c where c.producto.id = :id and c.usuario.email = :correo")
    CalificacionProducto obtenerCalificacionProducto(int id, String correo);

    // Query para listar las calificaciones de un usuario
    @Query("select c from CalificacionProducto c where c.usuario.email = :correo")
    List<CalificacionProducto> listarCalificacionesUsuario(String correo);

    // Query para obtener la calificacion total de un producto
    @Query("select avg(c.puntuacion) from CalificacionProducto c where c.producto.id = :id")
    Double obtenerCalificacionTotalProducto(int id);

    // Query para listar las calificaciones de un producto ordenadas por fecha mas reciente
    @Query("select c from CalificacionProducto c where c.producto.id = :id order by c.fecha desc")
    List<CalificacionProducto> listarCalificacionesProductoOrdenadas(int id);

    // Query para listar las calificaciones de un producto ordenadas por fecha mas antigua
    @Query("select c from CalificacionProducto c where c.producto.id = :id order by c.fecha asc")
    List<CalificacionProducto> listarCalificacionesProductoOrdenadasAntiguo(int id);

    // Query para listar las calificaciones de un producto ordenadas por puntuacion mas alta
    @Query("select c from CalificacionProducto c where c.producto.id = :id order by c.puntuacion desc")
    List<CalificacionProducto> listarCalificacionesProductoOrdenadasPuntuacion(int id);

    // Query para listar las calificaciones de un producto ordenadas por puntuacion mas baja
    @Query("select c from CalificacionProducto c where c.producto.id = :id order by c.puntuacion asc")
    List<CalificacionProducto> listarCalificacionesProductoOrdenadasPuntuacionBaja(int id);

}
