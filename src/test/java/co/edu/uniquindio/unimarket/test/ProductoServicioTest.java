package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.dto.ProductoDTO;
import co.edu.uniquindio.unimarket.modelo.Categoria;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
public class ProductoServicioTest {

    @Autowired
    private ProductoServicio productoServicio;

    public void crearProducto() throws Exception{

        Categoria categoria = Categoria.ACCESORIOS;

        ProductoDTO productoGetDTO = new ProductoDTO(
                "Carro",
                "Carro",
                4,
                23000,
                true,
                "5",
                null,
                categoria
                );
        //int nuevo = productoServicio.crearProducto(Produc);
    }

}
