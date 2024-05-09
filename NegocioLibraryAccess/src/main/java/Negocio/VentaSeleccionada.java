
package Negocio;

import DTO.PagoDTO;

/**
 *
 * @author Bell
 */
public class VentaSeleccionada {
    
     private static PagoDTO VentaSeleccionada;
    
    public static PagoDTO getPersonaSeleccionada() {
        return VentaSeleccionada;
    }

    public static void setPersonaSeleccionada(PagoDTO pago) {
        VentaSeleccionada = pago;
    }
}
