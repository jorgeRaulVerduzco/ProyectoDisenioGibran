/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AgregaProducto;

import DTO.ProductoDTO;
import IAgregaProducto.IAgregaProducto;
import INegocio.IProductoBO;
import Negocio.ProductoBO;


/**
 *
 * @author INEGI
 */
public class AgregaProducto implements IAgregaProducto{

  IProductoBO agregarProductoBO;

    public AgregaProducto() {
        agregarProductoBO = new ProductoBO();
    }

    @Override
    public void agregarProducto(ProductoDTO productoDTO) {
        agregarProductoBO.agregarProducto(productoDTO);
    }

    
}
