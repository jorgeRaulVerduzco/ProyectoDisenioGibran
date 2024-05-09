
package HistorialUsuario;

import DTO.PagoDTO;
import IHistorialUsuario.IHistorialUsuario;
import INegocio.IPagoBO;
import Negocio.PagoBO;
import java.util.List;

/**
 *
 * @author Bell
 */
public class HistorialUsuario implements IHistorialUsuario {
    IPagoBO pagoBO;

    public HistorialUsuario() {
        pagoBO= new PagoBO();
    }
    
    public List<PagoDTO> consultarHistorialCompras(String nombreUsuario){
        return pagoBO.consultarHistorialCompras(nombreUsuario);
    }
}
