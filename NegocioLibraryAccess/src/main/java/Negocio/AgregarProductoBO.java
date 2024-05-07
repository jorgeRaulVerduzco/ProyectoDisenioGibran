/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAO.ProductoDAO;
import DTO.ProductoDTO;
import Dominio.Producto;
import Excepciones.PersistenciaException;
import IDAO.IProductoDAO;
import INegocio.IAgregarProductoBO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author INEGI
 */
public class AgregarProductoBO implements IAgregarProductoBO {

    IProductoDAO productoDao;
    DTOaEntidadBO dtoaAentidad;

    public AgregarProductoBO() {
        productoDao = new ProductoDAO();
        dtoaAentidad = new DTOaEntidadBO();
    }

    @Override
    public void agregarProducto(ProductoDTO productoDTO) {
        Producto producto = dtoaAentidad.ConvertirProductoDTO(productoDTO);
        try {
            productoDao.agregarProducto(producto);
        } catch (PersistenciaException ex) {
            Logger.getLogger(AgregarProductoBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
