/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAO.ProductoDAO;
import DAO.UsuarioDAO;
import DTO.ProductoDTO;
import DTO.UsuarioDTO;
import Dominio.Producto;
import Dominio.Usuario;
import Excepciones.PersistenciaException;
import IDAO.IUsuarioDAO;
import INegocio.IUsuarioBO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author INEGI
 */
public class UsuarioBO implements IUsuarioBO {

    IUsuarioDAO usuarioDAO;
    DTOaEntidadBO dtoaEntidadBO;
    ProductoDAO productoDao;

    public UsuarioBO() {
        productoDao = new ProductoDAO();
        usuarioDAO = new UsuarioDAO();
        dtoaEntidadBO = new DTOaEntidadBO();

    }

    @Override
    public void agregarUsuario(UsuarioDTO usuarioDTO) {
        try {
            usuarioDAO.agregarUsuario(dtoaEntidadBO.ConvertirUsuarioDTO(usuarioDTO));
        } catch (PersistenciaException ex) {
            Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean buscarUsuario(String nombreUsuario, String contraseña) {
        try {
            return usuarioDAO.buscarUsuario(nombreUsuario, contraseña);
        } catch (PersistenciaException ex) {
            Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public UsuarioDTO UsuarioInicioSesion(String nombreUsuario, String contraseña) {
        try {
            Usuario usuario = usuarioDAO.UsuarioInicioSesion(nombreUsuario, contraseña);
            if (usuario != null) {
                UsuarioDTO usuarioDTO = new UsuarioDTO();
                usuarioDTO.setNombreUsuario(usuario.getNombreUsuario());
                usuarioDTO.setContraseña(usuario.getContraseña());
                return usuarioDTO;
            } else {
                return null;
            }
        } catch (PersistenciaException ex) {
            Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void agregarProductoVendido(String nombreUsuario, ProductoDTO productoVendido) {
        try {
            Producto producto = dtoaEntidadBO.ConvertirProductoDTO(productoVendido);

            usuarioDAO.agregarProductoVendido(nombreUsuario, producto);
        } catch (PersistenciaException ex) {
            Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<ProductoDTO> obtenerHistorialProductosVendidos(String nombreUsuario) {
        List<ProductoDTO> historialProductosVendidos = new ArrayList<>();
        try {
            List<Producto> productosVendidos = usuarioDAO.obtenerHistorialProductosVendidos(nombreUsuario);

            for (Producto producto : productosVendidos) {
                ProductoDTO productoDTO = convertirAProductoDTO(producto);
                historialProductosVendidos.add(productoDTO);
            }
        } catch (PersistenciaException ex) {
            Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return historialProductosVendidos;
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
}
