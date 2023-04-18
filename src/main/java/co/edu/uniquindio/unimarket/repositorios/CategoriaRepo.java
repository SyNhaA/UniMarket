package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepo extends JpaRepository<Categoria, Integer> {

    //Lista de categorias segun el codigo del producto
    @Query("select c from Categoria c where c.producto.codigo = :codigoProducto")
    List<Categoria> obtenerCategoriasSegunProducto(int codigoProducto);

    //categoria segun el id(int)
    @Query("select c from Categoria c where c.id = :idCategoria")
    Categoria obtenerCategoriaPorId(int idCategoria);


}
