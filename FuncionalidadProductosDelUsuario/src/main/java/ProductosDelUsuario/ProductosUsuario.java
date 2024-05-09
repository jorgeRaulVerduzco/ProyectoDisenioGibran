/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProductosDelUsuario;

import DTO.ProductoDTO;
import INegocio.IPagoBO;
import IProductosDelUsuario.IProductosUsuario;
import Negocio.PagoBO;
import java.util.List;


/**
 *
 * @author INEGI
 */
public class ProductosUsuario implements IProductosUsuario{
    IPagoBO pagoBO;

    public ProductosUsuario() {
        pagoBO= new PagoBO();
    }
    
    @Override
    public List<ProductoDTO> consultarProductosCompradosPorUsuario(String nombreUsuario){
        return pagoBO.consultarProductosCompradosPorUsuario(nombreUsuario);
    }
    
    
    
}
