package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.modelo.Compra;
import co.edu.uniquindio.unimarket.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CompraRepo extends JpaRepository<Compra, Integer> {

    // Query para listar las compras de un usuario
    @Query("select c from Compra c where c.usuario.email = :correo")
    List<Compra> listarComprasUsuario(String correo);

    // Query para listar las compras de un usuario en un rango de fechas
    @Query("select c from Compra c where c.usuario.email = :correo and c.fechaCompra between :fechaInicio and :fechaFin")
    List<Compra> listarComprasUsuarioEntreFechas(String correo, LocalDate fechaInicio, LocalDate fechaFin);

    // Query para listar las compras de un usuario entre un rango de precios
    @Query("select c from Compra c where c.usuario.email = :correo and c.total between :precioInicio and :precioFin")
    List<Compra> listarComprasUsuarioEntrePrecios(String correo, double precioInicio, double precioFin);

    // Query para listar los usuarios que han comprado un producto
    @Query("select c.usuario from Compra c join c.listaDetalleCompras dc where dc.producto.id = :idProducto")
    List<Usuario> listarUsuariosCompradoresProducto(int idProducto);

}
