package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.modelo.CalificacionVendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalificacionVendedorRepo extends JpaRepository<CalificacionVendedor, Integer> {

    // Query para listar las calificaciones de un vendedor
    @Query("select c from CalificacionVendedor c where c.vendedor.email = :correo")
    List<CalificacionVendedor> listarCalificacionesVendedor(String correo);

    // Query para obtener la calificacion de un vendedor hecha por un comprador especifico
    @Query("select c from CalificacionVendedor c where c.vendedor.email = :correo and c.comprador.email = :correo2")
    CalificacionVendedor obtenerCalificacionVendedor(String correo, String correo2);

    // Query para listar las calificaciones de un comprador
    @Query("select c from CalificacionVendedor c where c.comprador.email = :correo")
    List<CalificacionVendedor> listarCalificacionesComprador(String correo);

    // Query para obtener la calificacion total de un vendedor
    @Query("select avg(c.puntuacion) from CalificacionVendedor c where c.vendedor.email = :correo")
    Double obtenerCalificacionTotalVendedor(String correo);

    // Query para listar las calificaciones de un vendedor ordenadas por fecha mas reciente
    @Query("select c from CalificacionVendedor c where c.vendedor.email = :correo order by c.fecha desc")
    List<CalificacionVendedor> listarCalificacionesVendedorOrdenadas(String correo);

    // Query para listar las calificaciones de un vendedor ordenadas por fecha mas antigua
    @Query("select c from CalificacionVendedor c where c.vendedor.email = :correo order by c.fecha asc")
    List<CalificacionVendedor> listarCalificacionesVendedorOrdenadasAntiguo(String correo);

    // Query para listar las calificaciones de un vendedor ordenadas por puntuacion mas alta
    @Query("select c from CalificacionVendedor c where c.vendedor.email = :correo order by c.puntuacion desc")
    List<CalificacionVendedor> listarCalificacionesVendedorOrdenadasPuntuacion(String correo);

    // Query para listar las calificaciones de un vendedor ordenadas por puntuacion mas baja
    @Query("select c from CalificacionVendedor c where c.vendedor.email = :correo order by c.puntuacion asc")
    List<CalificacionVendedor> listarCalificacionesVendedorOrdenadasPuntuacionBaja(String correo);

}
