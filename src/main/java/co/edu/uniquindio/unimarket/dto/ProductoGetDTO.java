package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.modelo.Categoria;
import co.edu.uniquindio.unimarket.modelo.EstadoProducto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ProductoGetDTO {

    public ProductoGetDTO() {
    }

    private int codigo;

    private boolean activo;

    private LocalDateTime fechaCreado;

    private LocalDateTime fechaLimite;

    private String nombre;

    private String descripcion;

    private int unidades;

    private double precio;

    private String codigoVendedor;

    private List<String> imagenes;

    private Categoria categorias;
}
