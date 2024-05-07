/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProductosPorNombre;

import DTO.ProductoDTO;
import Excepciones.PersistenciaException;
import INegocio.IProductoBO;
import IProductosPorNombre.IProductosPorNombre;
import Negocio.ProductoBO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author INEGI
 */
public class ProductosPorNombre implements IProductosPorNombre{

    IProductoBO buscarProductosPorNombreBO;

    public ProductosPorNombre() {

        buscarProductosPorNombreBO = new ProductoBO();
    }

    @Override
    public List<ProductoDTO> buscarProductosPorNombre(String nombre) {
        return buscarProductosPorNombreBO.buscarProductosPorNombre(nombre);
    }
}
