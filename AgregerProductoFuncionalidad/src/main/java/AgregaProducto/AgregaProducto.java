/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AgregaProducto;

import DTO.ProductoDTO;
import Negocio.AgregarProductoBO;
import Negocio.ComprarProductoBO;

/**
 *
 * @author INEGI
 */
public class AgregaProducto {

    AgregarProductoBO agregarProductoBO;

    public AgregaProducto() {
        agregarProductoBO = new AgregarProductoBO();
    }

    public void agregarProducto(ProductoDTO productoDTO) {
        agregarProductoBO.agregarProducto(productoDTO);
    }

    
}
