package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.modelo.Favorito;
import co.edu.uniquindio.unimarket.modelo.Producto;
import co.edu.uniquindio.unimarket.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoritoRepo extends JpaRepository<Favorito, Integer> {

    //Favorito segun el id(int)
    Favorito findById(int id);

    //Lista de productos segun la cedula(string) del usuario
    @Query("SELECT f.producto FROM Favorito f WHERE f.usuario.cedula = :cedula")
    List<Producto> findByCedulaUsuario(String cedula);


    //Lista de usuarios segun el codigo(int) de un producto
    @Query("SELECT f.usuario FROM Favorito f WHERE f.producto.codigo = :productoId")
    List<Usuario> findByProductoId(int productoId);
}
