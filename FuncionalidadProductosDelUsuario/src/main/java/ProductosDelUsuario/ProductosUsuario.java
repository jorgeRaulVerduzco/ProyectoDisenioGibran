/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProductosDelUsuario;

import INegocio.IPagoBO;
import Negocio.PagoBO;
import java.util.List;


/**
 *
 * @author INEGI
 */
public class ProductosUsuario {
    IPagoBO pagoBO;

    public ProductosUsuario() {
        pagoBO= new PagoBO();
    }
    
    public List<Object> consultarProductosCompradosPorUsuario(String nombreUsuario){
        return pagoBO.consultarProductosCompradosPorUsuario(nombreUsuario);
    }
    
    
    
}
