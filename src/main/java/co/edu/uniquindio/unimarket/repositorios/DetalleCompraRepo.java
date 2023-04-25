package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.modelo.DetalleCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleCompraRepo extends JpaRepository<DetalleCompra, Integer> {

    // Query para buscar un detalle de compra por el precio del producto
    DetalleCompra findByPrecioProducto(double precio);

    // Query para listar los detalles de una compra
    @Query("select dc from DetalleCompra dc where dc.compra.id = :idCompra")
    List<DetalleCompra> listarDetallesCompra(int idCompra);

    // Query para listar los detalles de un producto
    @Query("select dc from DetalleCompra dc where dc.producto.id = :idProducto")
    List<DetalleCompra> listarDetallesProducto(int idProducto);

}
