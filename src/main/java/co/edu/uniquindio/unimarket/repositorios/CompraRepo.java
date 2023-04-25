package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.modelo.Compra;
import co.edu.uniquindio.unimarket.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CompraRepo extends JpaRepository<Compra, Integer> {

    //Compra segun el id
    Compra findById(int id);


    //Usuario segun un id(int) de la compra
    @Query("select u from Usuario u inner join u.listaCompras c where c.id = :compraId")
    Usuario findByCompraId(int compraId);

    //Lista de compra segun fecha de compra
    @Query("select c from Compra c where c.fechaCompra = :fechaCompra")
    List<Compra> findByFechaCompra(LocalDateTime fechaCompra);

    //Lista de comprar con un total mayor a total(double)
    @Query("select c from Compra c where c.total > :total")
    List<Compra> findByTotalGreaterThan(double total);
}
