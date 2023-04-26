package co.edu.uniquindio.unimarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class DetalleCompraGetDTO {

    private int id;

    private int codigoProducto;

    private int codigoCompra;

    private int unidades;

    private double precio;

}
