package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.CompraDTO;
import co.edu.uniquindio.unimarket.dto.CompraGetDTO;
import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.util.List;

public interface CompraServicio {

    int crearCompra(CompraDTO compraDTO) throws Exception;

    List<CompraGetDTO> listarCompras(String codigoUsuario);

    CompraGetDTO obtenerCompra(int codigoCompra);

    double obtenerComprasSegunMesyAnio(Year anio, Month mes) throws Exception;

    List<ProductoGetDTO> obtenerProductoCompradorPorUnUsuarioSinRepetir(String cedula) throws Exception;

}
