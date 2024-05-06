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
import INegocio.IBuscarProductoPorNombreBO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author INEGI
 */
public class BuscarProductoPorNombreBO implements IBuscarProductoPorNombreBO{

    private IProductoDAO productoDAO;
    private DTOaEntidadBO dtoAentidad;

    public BuscarProductoPorNombreBO() {
        productoDAO = new ProductoDAO();
        dtoAentidad = new DTOaEntidadBO();
    }

    @Override
    public List<ProductoDTO> buscarProductosPorNombre(String nombre)  {
        try {
            List<Producto> productos = productoDAO.buscarProductosPorNombre(nombre);
            List<ProductoDTO> productosDTO = new ArrayList<>();
            
            for (Producto producto : productos) {
                ProductoDTO productoDTO = convertirAProductoDTO(producto);
                productosDTO.add(productoDTO);
            }
            
            return productosDTO;
        } catch (PersistenciaException ex) {
            Logger.getLogger(BuscarProductoPorNombreBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ProductoDTO convertirAProductoDTO(Producto producto) {
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setIsbn(producto.getIsbn());
        productoDTO.setTitulo(producto.getTitulo());
        productoDTO.setAutor(producto.getAutor());
        productoDTO.setTipo(producto.getTipo());
        productoDTO.setEditorial(producto.getEditorial());
        productoDTO.setPrecio(producto.getPrecio());
        productoDTO.setCategoria(producto.getCategoria());
        productoDTO.setCantidad(producto.getCantidad());
        return productoDTO;
    }

    @Override
    public String toString() {
        return "BuscarProductoPorNombreBO{" +
                "productoDAO=" + productoDAO +
                ", dtoAentidad=" + dtoAentidad +
                '}';
    }
}
