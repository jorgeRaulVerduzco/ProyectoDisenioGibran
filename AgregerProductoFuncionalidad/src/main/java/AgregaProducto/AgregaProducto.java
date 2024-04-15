/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AgregaProducto;

import DTO.ProductoDTO;
import IAgregaProducto.IAgregaProducto;
import INegocio.IAgregarProductoBO;
import Negocio.AgregarProductoBO;
import Negocio.ComprarProductoBO;

/**
 *
 * @author INEGI
 */
public class AgregaProducto implements IAgregaProducto{

    IAgregarProductoBO agregarProductoBO;

    public AgregaProducto() {
        agregarProductoBO = new AgregarProductoBO();
    }

    @Override
    public void agregarProducto(ProductoDTO productoDTO) {
        agregarProductoBO.agregarProducto(productoDTO);
    }

    
}
