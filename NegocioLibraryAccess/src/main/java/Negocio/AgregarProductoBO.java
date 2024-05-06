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
    public void agregarProducto(ProductoDTO productoDTO) throws PersistenciaException {
        Producto producto = dtoaAentidad.ConvertirProductoDTO(productoDTO);
        productoDao.agregarProducto(producto);
    }
}
