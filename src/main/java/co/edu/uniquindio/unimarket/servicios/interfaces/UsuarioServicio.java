package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioGetDTO;
import co.edu.uniquindio.unimarket.modelo.Usuario;

import java.util.List;

public interface UsuarioServicio {


    int crearUsuario(UsuarioDTO usuarioDTO)  throws Exception;

    int actualizarUsuario(int codigoUsuario, UsuarioDTO usuarioDTO) throws Exception;

    int eliminiarUsuario(int codigoUsuario) throws Exception;

    Usuario obtenerUsuario(String codigoUsuario) throws Exception;

    List<UsuarioGetDTO> listarUsuarios();
}
