/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProductosPorNombre;

import DTO.ProductoDTO;
import INegocio.IBuscarProductoPorNombreBO;
import IProductosPorNombre.IProductosPorNombre;
import Negocio.BuscarProductoPorNombreBO;
import java.util.List;

/**
 *
 * @author INEGI
 */
public class ProductosPorNombre implements IProductosPorNombre{

    IBuscarProductoPorNombreBO buscarProductosPorNombreBO;

    public ProductosPorNombre() {

        buscarProductosPorNombreBO = new BuscarProductoPorNombreBO();
    }

    @Override
    public List<ProductoDTO> buscarProductosPorNombre(String nombre) {
        return buscarProductosPorNombreBO.buscarProductosPorNombre(nombre);
    }
}
