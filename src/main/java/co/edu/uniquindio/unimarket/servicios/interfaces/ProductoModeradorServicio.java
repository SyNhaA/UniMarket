package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.ModeradorGetDTO;
import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;

import java.util.List;

public interface ProductoModeradorServicio {

    List<ProductoGetDTO> listarProductosPorModerador(ModeradorGetDTO moderadorGetDTO);

}
