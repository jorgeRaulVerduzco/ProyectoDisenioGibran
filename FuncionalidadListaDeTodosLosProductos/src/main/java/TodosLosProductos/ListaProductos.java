/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TodosLosProductos;

import DTO.ProductoDTO;
import INegocio.IProductoBO;
import ITodosLosProductos.IListaProductos;
import Negocio.ProductoBO;
import java.util.List;

/**
 *
 * @author JORGE
 */
public class ListaProductos implements IListaProductos {

    IProductoBO productoBO;

    public ListaProductos() {
        productoBO = new ProductoBO();
    }

    @Override
    public List<ProductoDTO> listaProductos() {
        return productoBO.listaProductos();
    }

}
