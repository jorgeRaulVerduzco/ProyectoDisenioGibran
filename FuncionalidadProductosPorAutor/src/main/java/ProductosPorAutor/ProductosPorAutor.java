/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProductosPorAutor;

import DTO.ProductoDTO;
import INegocio.IProductoBO;
import IProductosPorAutor.IProductosPorAutor;
import Negocio.ProductoBO;
import java.util.List;

/**
 *
 * @author JORGE
 */
public class ProductosPorAutor implements IProductosPorAutor {

    IProductoBO productoBO;

    public ProductosPorAutor() {
        productoBO = new ProductoBO();
    }

    @Override
    public List<ProductoDTO> buscarProductosPorAutor(String autor) {
        return productoBO.buscarProductosPorAutor(autor);
    }

}
