package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.dto.CompraDTO;
import co.edu.uniquindio.unimarket.modelo.MedioPago;
import co.edu.uniquindio.unimarket.servicios.implementacion.CompraServicioImpl;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.Month;
import java.time.Year;

@SpringBootTest
@Transactional
public class CompraServicioTest {

    @Autowired
    private CompraServicioImpl compraServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void crearCompra() throws Exception {
        CompraDTO compra = new CompraDTO();
        compra.setCedulaUsuario("0000000001");
        compra.setMedioPago(MedioPago.EFECTIVO);
        compra.setTotal(58000);
        compra.setDetalleCompraDTO(null);
        int verificador = compraServicio.crearCompra(compra);

        Assertions.assertEquals(0, verificador);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerComprasSegunMesyAnio() throws Exception{
        Year year = Year.of(2022);
        Month month = Month.of(2);

        System.out.println("AÑAÑAI");
        System.out.println("Año" + year.getValue() + "Mes" +month.getValue());
        compraServicio.obtenerComprasSegunMesyAnio(year, month);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerProductoCompradorPorUnUsuarioSinRepetir() throws Exception{
        compraServicio.obtenerProductoCompradorPorUnUsuarioSinRepetir("0000000001");
    }


}
