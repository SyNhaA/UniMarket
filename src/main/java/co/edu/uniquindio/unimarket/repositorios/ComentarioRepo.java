package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.modelo.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ComentarioRepo extends JpaRepository<Comentario, Integer> {

    // Query para listar los comentarios de un usuario
    @Query("select c from Comentario c where c.usuario.email = :correo")
    List<Comentario> listarComentariosUsuario(String correo);

    // Query para listar los comentarios de un producto
    @Query("select c from Comentario c where c.producto.id = :idProducto")
    List<Comentario> listarComentariosProducto(Integer idProducto);

    // Query para listar los comentarios de un producto ordenados por fecha de creacion mas reciente
    @Query("select c from Comentario c where c.producto.id = :idProducto order by c.fechaCreacion desc")
    List<Comentario> listarComentariosProductoOrdenadosFecha(Integer idProducto);

    // Query para listar los comentarios de un producto ordenados por fecha de creacion mas antigua
    @Query("select c from Comentario c where c.producto.id = :idProducto order by c.fechaCreacion asc")
    List<Comentario> listarComentariosProductoOrdenadosFechaAsc(Integer idProducto);

    // Query para listar los comentarios de un producto en un rango de fechas
    @Query("select c from Comentario c where c.producto.id = :idProducto and c.fechaCreacion between :fechaInicio and :fechaFin")
    List<Comentario> listarComentariosProductoRangoFechas(Integer idProducto, LocalDate fechaInicio, LocalDate fechaFin);

}
