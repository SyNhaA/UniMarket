package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.dto.ImagenDTO;
import co.edu.uniquindio.unimarket.dto.ProductoDTO;
import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.modelo.Categoria;
import co.edu.uniquindio.unimarket.modelo.Producto;
import co.edu.uniquindio.unimarket.servicios.implementacion.ProductoServicioImpl;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
public class ProductoServicioTest {

    @Autowired
    private ProductoServicioImpl productoServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void crearProducto() throws Exception{

        Categoria categoria = Categoria.ACCESORIOS;
        List<String> imagenes = new ArrayList<>();

        ProductoDTO productoGetDTO = new ProductoDTO(

                "Carro",
                LocalDateTime.now().plusDays(30),
                "Carro rojo",
                4,
                23000,
                true,
                "0000000009",
                imagenes,
                Categoria.OTROS
                );
        Producto producto = productoServicio.crearProducto(productoGetDTO);

        Assertions.assertEquals(23000, producto.getPrecio());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarProducto() throws Exception{
        Producto producto = productoServicio.obtenerProducto(1);
        producto.setActivo(false);
        producto.setUnidades(50000);

        producto = productoServicio.actualizarProducto(producto);
        Assertions.assertEquals(50000,producto.getUnidades());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarUnidades() throws Exception{
        productoServicio.actualizarUnidades(1,80000);
        Producto producto = productoServicio.obtenerProducto(1);

        Assertions.assertEquals(80000, producto.getUnidades());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarProducto() throws Exception{

        int cero = productoServicio.eliminarProducto(1);
        Assertions.assertEquals(0, cero);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void productoMasCaroBaratoSegunCategoria()throws Exception{
        List<ProductoGetDTO> productos = productoServicio.productoMasCaroYMasBarato(Categoria.TECNOLOGIA);

        Assertions.assertEquals(2699.99, productos.get(0).getPrecio());
    }

}
