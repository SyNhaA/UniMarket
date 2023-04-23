package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioGetDTO;

public interface UsuarioServicio {


    int crearUsuario(UsuarioDTO usuarioDTO)  throws Exception;

    int actualizarUsuario(int codigoUsuario, UsuarioDTO usuarioDTO) throws Exception;

    int eliminiarUsuario(int codigoUsuario) throws Exception;

    UsuarioGetDTO obtenerUsuario(int codigoUsuario) throws Exception;

}
