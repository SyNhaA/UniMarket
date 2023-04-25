package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.modelo.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ComentarioRepo extends JpaRepository<Comentario, Integer> {


    //Comentario segun el codigo(int) del comentario
    Comentario findByCodigo(int codigo);

    //Lista de comentarios de un usuario, cedula(int) del usuario
    @Query("select c from Comentario c where c.usuario.cedula = :idUsuario")
    List<Comentario> obtenerComentariosDeUsuario(String idUsuario);


    //Lista de comentarios de un producto, codigo(int) del producto
    @Query("select c from Comentario c where c.producto.codigo = :idProducto")
    List<Comentario> obtenerComentariosDeProducto(int idProducto);

    //Lista de comentario segun fecha de creacion
    List<Comentario> findByFechaCreacion(LocalDateTime fechaCreacion);

    //Lista de comentarios en un rango de fechas
    @Query("select c from Comentario c where c.fechaCreacion >= :fechaInicio and c.fechaCreacion <= :fechaFin")
    List<Comentario> obtenerComentariosPorRangoDeFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin);


}
