package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.modelo.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImagenRepo extends JpaRepository<Imagen, Integer> {

    // Query para buscar una imagen por su url
    Imagen findByUrl(String url);

    // Query para listar las imagenes de un producto
    @Query("select i from Imagen i where i.producto.id = :id")
    List<Imagen> listarImagenesProducto(int id);

}
