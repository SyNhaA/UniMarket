package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.modelo.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, String> {

    // Query para buscar un usuario por su correo
    Usuario findByEmail(String correo);

    // Query para comprobar la autenticacion de un usuario
    @Query("select u from Usuario u where u.email = :correo and u.contrasenia = :password")
    Usuario autenticarUsuario(String correo, String password);

    // Query para listar los productos favoritos de un usuario
    @Query("select u.productosFavoritos from Usuario u where u.email = :correo")
    List<Producto> listarProductosFavoritosUsuario(String correo);

}
