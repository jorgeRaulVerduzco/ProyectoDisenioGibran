package HistorialUsuario;

import DTO.PagoDTO;
import IHistorialUsuario.IHistorialUsuario;
import INegocio.IPagoBO;
import Negocio.PagoBO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bell
 */
public class HistorialUsuario implements IHistorialUsuario {

    
    IPagoBO pagoBO;

    public HistorialUsuario() {
        pagoBO = new PagoBO();
    }

    

    

    @Override
    public List<Object> consultarHistorialComprasPorUsuario(String nombreUsuario) {
        try {
            List<Object> productosEncontrados = pagoBO.consultarHistorialComprasPorUsuario(nombreUsuario);
            if (productosEncontrados == null) {
                return new ArrayList<>(); // Devuelve una lista vacía en lugar de null
            }
            return productosEncontrados;
        } catch (Exception e) { // Imprime el error para depuración
            // Imprime el error para depuración
            return new ArrayList<>(); // Devuelve una lista vacía en caso de excepción
        }
    }
}

