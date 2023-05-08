package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.ComentarioDTO;
import co.edu.uniquindio.unimarket.dto.ComentarioGetDTO;

import java.util.List;

public interface ComentarioServicio {

    int crearComentario(ComentarioDTO comentarioDTO) throws Exception;

    int eliminiarComentario(int codigoComentario) throws Exception;

    ComentarioGetDTO obtenerComentario(int codigoComentario) throws Exception;

    List<ComentarioGetDTO> listarComentarios(int codigoProducto) throws Exception;

}
