package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioGetDTO;
import co.edu.uniquindio.unimarket.modelo.Usuario;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioServicioImpl implements UsuarioServicio {

    @Override
    public int crearUsuario(UsuarioDTO usuarioDTO) throws Exception {
        return 0;
    }

    @Override
    public int actualizarUsuario(int codigoUsuario, UsuarioDTO usuarioDTO) throws Exception {
        return 0;
    }

    @Override
    public int eliminiarUsuario(int codigoUsuario) throws Exception {
        return 0;
    }

    @Override
    public Usuario obtenerUsuario(String codigoUsuario) throws Exception {
        return null;
    }
}
