package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.modelo.Moderador;
import co.edu.uniquindio.unimarket.modelo.Producto;
import co.edu.uniquindio.unimarket.repositorios.ModeradorRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.ModeradorServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ModeradorServicioImpl implements ModeradorServicio {

    private final ModeradorRepo moderadorRepo;
    private final ProductoServicioImpl productoServicio;


    @Override
    public void aprobarProducto(int codigoProducto) throws Exception {

        Producto producto = productoServicio.obtenerProducto(codigoProducto);
        if (producto!= null){
            if (!producto.isActivo()){
                producto.setActivo(true);
            }else {
                throw new Exception("El producto ya esta aprovado");
            }

        }else {
            throw new Exception("producto en el codigo: "+ codigoProducto+ "No se a encontrado");
        }

    }

    @Override
    public void rechazarProducto(int codigoProducto) throws Exception {

        Producto producto = productoServicio.obtenerProducto(codigoProducto);
        if (producto!= null){
            if (producto.isActivo()){
                producto.setActivo(false); //Preguntar
            }else {
                throw new Exception("El producto esta Rechazado");
            }

        }else {
            throw new Exception("producto en el codigo: "+ codigoProducto+ "No se a encontrado");
        }
    }

    @Override
    public Moderador obtenerModerador(String codigoModerador) throws Exception {
        Optional<Moderador> moderador = moderadorRepo.findById(codigoModerador);

        if(moderador.isEmpty() ) {
            throw new Exception("El código " + codigoModerador + " no está asociado a ningún usuario");
        }
        return moderador.get();
    }
}
