package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioGetDTO;
import co.edu.uniquindio.unimarket.servicios.implementacion.UsuarioServicioImpl;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/clientes")
public class ClienteController {

    private final UsuarioServicio usuarioServicio;

    public List<UsuarioGetDTO> listar(){
        return null;
    }
    public UsuarioGetDTO obtener(int codigo){
        return null;
    }
    public int registrar(UsuarioDTO cliente){
        return 0;
    }
    public void eliminar(int codigo){
    }

    public UsuarioGetDTO actualizar(int codigo, UsuarioDTO cliente){
        return null;
    }

    @GetMapping
    public List<UsuarioGetDTO> listarClientes(){
        return null;
    }
    @GetMapping("/{codigo}")
    public UsuarioGetDTO obtener(@PathVariable int codigo){
        return null;
    }
    @PostMapping
    public int registrar(@Valid @RequestBody UsuarioDTO cliente){
        return 0;
    }
    @DeleteMapping("/{codigo}")
    public void eliminar(@PathVariable int codigo){
    }
    @PutMapping("/{codigo}")
    public UsuarioGetDTO actualizar(@PathVariable int codigo, @Valid @RequestBody ClientePostDTO
            cliente){
        return null;
    }

    @GetMapping
    public List<UsuarioGetDTO> listar(){
        return usuarioServicio.listarUsuarios();
    }
    @PostMapping
    public int registrar(@Valid @RequestBody UsuarioDTO cliente) throws Exception{
        return usuarioServicio.crearUsuario(cliente);
    }
    @GetMapping("/{codigo}")
    public UsuarioGetDTO obtener(@PathVariable int codigo) throws Exception{
        return clienteServicio.obtenerCliente(codigo);
    }
    @DeleteMapping("/{codigo}")
    public void eliminar(@PathVariable int codigo) throws Exception{
        clienteServicio.eliminarCliente(codigo);
    }
    @PutMapping("/{codigo}")
    public UsuarioGetDTO actualizar(@PathVariable int codigo, @Valid @RequestBody ClientePostDTO
            cliente) throws Exception{
        return clienteServicio.actualizarCliente(codigo, cliente);
    }
}
