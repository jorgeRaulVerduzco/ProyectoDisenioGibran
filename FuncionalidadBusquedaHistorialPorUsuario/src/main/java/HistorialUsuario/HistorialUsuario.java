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

    

    

    
    public List<Object> consultarHistorialComprasPorUsuarioMeses(String nombreUsuario, int anio, int meses) {
    try {
        List<Object> productosEncontrados = pagoBO.consultarHistorialComprasPorUsuarioMeses(nombreUsuario, anio, meses);
        if (productosEncontrados == null) {
            return new ArrayList<>(); 
        }
        return productosEncontrados;
    } catch (Exception e) { 
        return new ArrayList<>(); 
    }
}
}

