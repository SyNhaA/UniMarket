package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.ComentarioDTO;
import co.edu.uniquindio.unimarket.dto.ComentarioGetDTO;
import co.edu.uniquindio.unimarket.modelo.Comentario;
import co.edu.uniquindio.unimarket.modelo.Producto;
import co.edu.uniquindio.unimarket.modelo.Usuario;
import co.edu.uniquindio.unimarket.repositorios.ComentarioRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.ComentarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ComentarioServicioImpl implements ComentarioServicio {

    private final ComentarioRepo comentarioRepo;
    private final UsuarioServicioImpl usuarioServicio;
    private final ProductoServicioImpl productoServicio;

    @Override
    public int crearComentario(ComentarioDTO comentarioDTO) throws Exception {

        Usuario usuario = usuarioServicio.obtenerUsuario(comentarioDTO.getCedulaUsuario());
        Producto producto = productoServicio.obtenerProducto(comentarioDTO.getCodigoProducto());

        if (usuario == null){
            throw new Exception("El código "+usuario.getCedula()+" no está asociado a ningún usuario");
        }
        if (producto == null){
            throw new Exception("El código "+producto.getId()+" no está asociado a ningún producto");
        }

        Comentario comentario = convertirComentarioDTOaComentario(comentarioDTO);
        comentario.setUsuario(usuario);
        comentario.setProducto(producto);

        comentarioRepo.save(comentario);
        return 0;
    }

    @Override
    public int eliminiarComentario(int codigoComentario) throws Exception {

        validarExistencia(codigoComentario);
        comentarioRepo.deleteById(codigoComentario);
        return codigoComentario;
    }

    @Override
    public ComentarioGetDTO obtenerComentario(int codigoComentario) throws Exception {
        validarExistencia(codigoComentario);
        Optional<Comentario> comentario = comentarioRepo.findById(codigoComentario);
        return convertirComentarioAGetDTO(comentario.get());
    }

    @Override
    public List<ComentarioGetDTO> listarComentarios(int codigoProducto) throws Exception {
        if(codigoProducto < 0){
            throw  new Exception("El codigo no es aceptable");
        }

        if(productoServicio.obtenerProducto(codigoProducto) == null){
            throw new Exception(("El producto no existe"));
        }

        List<Comentario> listaComentario = comentarioRepo.listarComentariosProducto(codigoProducto);
        List<ComentarioGetDTO> listaComentarioGetDTo = new ArrayList<>();

        for (Comentario comentario: listaComentario) {
            listaComentarioGetDTo.add(convertirComentarioAGetDTO(comentario));
        }

        return listaComentarioGetDTo;
    }

    private void validarExistencia(int codigoComentario) throws Exception {

        boolean existe = comentarioRepo.existsById(codigoComentario);

        if( !existe ){
            throw new Exception("El código no corresponde a ningun comentario");
        }
    }
    public Comentario convertirComentarioDTOaComentario(ComentarioDTO comentarioDTO) throws Exception {
        Comentario comentario = new Comentario();
        comentario.setMensaje(comentarioDTO.getMensaje());
        comentario.setFechaCreacion(comentarioDTO.getFechaCreacion());
        return comentario;
    }

    private ComentarioGetDTO convertirComentarioAGetDTO(Comentario comentario) {

        ComentarioGetDTO comentarioGetDTO = new ComentarioGetDTO(
                comentario.getId(),
                comentario.getFechaCreacion(),
                comentario.getMensaje(),
                comentario.getUsuario().getCedula(),
                comentario.getProducto().getId()
        );
        return  comentarioGetDTO;
    }
}
