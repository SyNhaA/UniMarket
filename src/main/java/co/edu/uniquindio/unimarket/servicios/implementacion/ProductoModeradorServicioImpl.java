package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.ModeradorGetDTO;
import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.modelo.Moderador;
import co.edu.uniquindio.unimarket.modelo.Producto;
import co.edu.uniquindio.unimarket.repositorios.ProductoModeradorRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoModeradorServicio;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductoModeradorServicioImpl implements ProductoModeradorServicio {

    private final ProductoModeradorRepo productoModeradorRepo;
    private final ProductoServicioImpl productoServicio;

    @Override
    public List<ProductoGetDTO> listarProductosPorModerador(ModeradorGetDTO moderadorGetDTO) {
        List<ProductoGetDTO> listaProductoGetDTO = new ArrayList<>();

        Moderador moderador = new Moderador();
        moderador.setCedula(moderadorGetDTO.getCedula());

        List<Producto> productos = productoModeradorRepo.listarProductosModerador(moderadorGetDTO.getEmail());

        for (Producto producto : productos) {
            listaProductoGetDTO.add(productoServicio.convertir_de_Producto_a_ProductoDTO(producto));
        }
        return listaProductoGetDTO;
    }
}
