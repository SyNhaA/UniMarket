package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.modelo.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImagenRepo extends JpaRepository<Imagen, Integer> {

    //Lista de imagenes(String) segun el id(int) de un producto
    List<Imagen> findByProductoCodigo(int codigo);
}
