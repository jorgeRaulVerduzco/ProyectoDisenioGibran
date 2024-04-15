/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAO.ProductoDAO;
import DTO.ProductoDTO;
import Dominio.Producto;

/**
 *
 * @author INEGI
 */
public class AgregarProductoBO {
ProductoDAO productoDao;
DTOaEntidadBO dtoaAentidad;
    public AgregarProductoBO() {
        productoDao = ProductoDAO.getInstancia();
        dtoaAentidad = new DTOaEntidadBO();
    }

    public void agregarProducto(ProductoDTO productoDTO) {
        Producto producto = dtoaAentidad.ConvertirProductoDTO(productoDTO);
        productoDao.agregarProducto(producto);
    }
}
