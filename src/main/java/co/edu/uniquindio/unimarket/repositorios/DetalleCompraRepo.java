package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.modelo.DetalleCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.naming.InterruptedNamingException;

@Repository
public interface DetalleCompraRepo extends JpaRepository<DetalleCompra, InterruptedNamingException> {

    //Detalle compra segun id(int)
    DetalleCompra findById(int id);

}
