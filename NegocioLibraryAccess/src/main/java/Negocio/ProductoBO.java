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
import INegocio.IProductoBO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author INEGI
 */
public class ProductoBO implements IProductoBO {
    
    IProductoDAO productoDao;
    DTOaEntidadBO dtoaAentidad;
    
    public ProductoBO() {
        productoDao = new ProductoDAO();
        dtoaAentidad = new DTOaEntidadBO();
    }
    
    @Override
    public void agregarProducto(ProductoDTO productoDTO) {
        Producto producto = dtoaAentidad.ConvertirProductoDTO(productoDTO);
        try {
            productoDao.agregarProducto(producto);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ProductoBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public List<ProductoDTO> buscarProductosPorNombre(String nombre) {
        try {
            List<Producto> productos = productoDao.buscarProductosPorNombre(nombre);
            List<ProductoDTO> productosDTO = new ArrayList<>();
            
            for (Producto producto : productos) {
                ProductoDTO productoDTO = convertirAProductoDTO(producto);
                productosDTO.add(productoDTO);
            }
            
            return productosDTO;
        } catch (PersistenciaException ex) {
            Logger.getLogger(ProductoBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public List<ProductoDTO> listaProductos() {
        try {
            List<Producto> productos = productoDao.obtenerTodosProductos();
            List<ProductoDTO> productosDTO = new ArrayList<>();
            
            for (Producto producto : productos) {
                ProductoDTO productoDTO = convertirAProductoDTO(producto);
                productosDTO.add(productoDTO);
            }
            
            return productosDTO;
        } catch (PersistenciaException ex) {
            Logger.getLogger(ProductoBO.class.getName()).log(Level.SEVERE, null, ex);
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
    public List<ProductoDTO> buscarProductosPorVendedor(String vendedor) {
        try {
            List<Producto> productos = productoDao.buscarProductosPorVendedor(vendedor);
            List<ProductoDTO> productosDTO = new ArrayList<>();
            
            for (Producto producto : productos) {
                ProductoDTO productoDTO = convertirAProductoDTO(producto);
                productosDTO.add(productoDTO);
            }
            
            return productosDTO;
        } catch (PersistenciaException ex) {
            Logger.getLogger(ProductoBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public String toString() {
        return "BuscarProductoPorNombreBO{"
                + "productoDAO=" + productoDao
                + ", dtoAentidad=" + dtoaAentidad
                + '}';
    }
    
}
