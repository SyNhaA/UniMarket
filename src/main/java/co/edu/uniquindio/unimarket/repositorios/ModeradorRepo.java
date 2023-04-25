package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.modelo.Moderador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeradorRepo extends JpaRepository<Moderador, String> {

    // Query para buscar un moderador por su correo
    Moderador findByEmail(String correo);

    // Query para comprobar la autenticacion de un moderador
    @Query("select m from Moderador m where m.email = :correo and m.contrasenia = :password")
    Moderador autenticarModerador(String correo, String password);

}
