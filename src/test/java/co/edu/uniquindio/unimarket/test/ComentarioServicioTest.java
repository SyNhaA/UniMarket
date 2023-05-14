package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.dto.ComentarioDTO;
import co.edu.uniquindio.unimarket.dto.ComentarioGetDTO;
import co.edu.uniquindio.unimarket.modelo.Comentario;
import co.edu.uniquindio.unimarket.servicios.implementacion.ComentarioServicioImpl;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Transactional
public class ComentarioServicioTest {

    @Autowired
    ComentarioServicioImpl comentarioServicio;
    @Autowired
    UsuarioServicio usuarioServicio;
    @Autowired
    ProductoServicio productoServicio;


    @Test
    @Sql("classpath:dataset.sql")
    public void crearComentario() throws Exception {
        ComentarioDTO comentarioDTO = new ComentarioDTO(
                "Muy bonito",
                "0000000001",
                1
        );
        int verificador = comentarioServicio.crearComentario(comentarioDTO);
        System.out.println(verificador);
        Assertions.assertEquals(0, verificador);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarComentario() throws Exception{
        int verificador = comentarioServicio.eliminiarComentario(1);
        Assertions.assertEquals(1, verificador);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerComentario() throws Exception{
        ComentarioGetDTO comentarioGetDTO = comentarioServicio.obtenerComentario(1);
        Assertions.assertEquals(1, comentarioGetDTO.getCodigo());
    }

}
