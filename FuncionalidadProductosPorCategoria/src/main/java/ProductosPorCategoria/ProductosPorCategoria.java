/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProductosPorCategoria;

import DTO.ProductoDTO;
import INegocio.IProductoBO;
import IProductosPorCategoria.IProductosPorCategoria;
import Negocio.ProductoBO;
import java.util.List;

/**
 *
 * @author JORGE
 */
public class ProductosPorCategoria implements IProductosPorCategoria{
   IProductoBO productoBO;

    public ProductosPorCategoria() {
    productoBO = new ProductoBO();
    
    }
   
   @Override
   public List<ProductoDTO> buscarProductosPorCategoria(String categoria){
       return productoBO.buscarProductosPorCategoria(categoria);
   }
}
