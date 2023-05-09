package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.modelo.Moderador;

public interface ModeradorServicio {

    void aprobarProducto(int codigoProducto) throws Exception;

    void rechazarProducto(int codigoProducto) throws Exception;

    Moderador obtenerModerador(String codigoModerador) throws Exception;

}
