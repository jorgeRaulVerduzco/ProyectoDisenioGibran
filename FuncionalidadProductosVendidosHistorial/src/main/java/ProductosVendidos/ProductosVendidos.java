/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProductosVendidos;

import DTO.ProductoDTO;
import INegocio.IProductoBO;
import IProductosVendidos.IListaProductosVendidos;
import Negocio.ProductoBO;
import java.util.List;

public class ProductosVendidos implements IListaProductosVendidos {
IProductoBO productoBO;

    public ProductosVendidos() {
        
        productoBO = new ProductoBO();
    }


    public List<ProductoDTO> buscarProductosPorVendedor(String vendedor){
        return productoBO.buscarProductosPorVendedor(vendedor);
    }

    

}
