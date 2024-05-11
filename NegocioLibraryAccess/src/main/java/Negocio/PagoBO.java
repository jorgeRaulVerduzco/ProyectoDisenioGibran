/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAO.PagoDAO;
import DAO.PagoPorOxxoDAO;
import DAO.PagoPorTarjetaDAO;
import DTO.PagoDTO;
import DTO.PagoPorOxxoDTO;
import DTO.PagoPorTarjetaDTO;
import DTO.ProductoDTO;
import DTO.UsuarioDTO;
import Dominio.Pago;
import Dominio.PagoPorOxxo;
import Dominio.PagoPorTarjeta;
import Dominio.Producto;
import Excepciones.PersistenciaException;
import IDAO.IPagoDAO;
import IDAO.IPagoPorOxxoDAO;
import IDAO.IPagoPorTarjetaDAO;
import INegocio.IPagoBO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author INEGI
 */
public class PagoBO implements IPagoBO {

    IPagoDAO pagoDAO;
    IPagoPorOxxoDAO pagoPorOxxoDAO;
    DTOaEntidadBO dtoAentidad;
    IPagoPorTarjetaDAO pagoPorTarjetaDAO;

    public PagoBO() {
        pagoDAO = new PagoDAO();
        dtoAentidad = new DTOaEntidadBO();
        pagoPorOxxoDAO = new PagoPorOxxoDAO();
        pagoPorTarjetaDAO = new PagoPorTarjetaDAO();
    }

    @Override
    public void ComprarProducto(PagoDTO pagoDTO) {
        Pago pago = dtoAentidad.ConvertirPagoDTO(pagoDTO);

        Producto producto = pago.getProducto().get(0);

        double precioProducto = producto.getPrecio();

        int cantidad = pago.getCantidad();

        double costoTotal = precioProducto * cantidad;

        pago.setCostoTotal(costoTotal);

        try {
            pagoDAO.agregarPago(pago);
        } catch (PersistenciaException ex) {
            Logger.getLogger(PagoBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ComprarProductoPorOxxo(PagoPorOxxoDTO pagoPorOxxoDTO) {
        PagoPorOxxo pagoPorOxxo = dtoAentidad.ConnvertirPagoOxxoDTO(pagoPorOxxoDTO);

        try {
            pagoPorOxxoDAO.agregarPago(pagoPorOxxo);
        } catch (PersistenciaException ex) {
            Logger.getLogger(PagoBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ComprarProductoPorTarjeta(PagoPorTarjetaDTO pagoPorTarjetaDTO) {
        PagoPorTarjeta pagoPorTarjeta = dtoAentidad.convertirPagoPorTarjetaDTO(pagoPorTarjetaDTO);

        try {
            pagoPorTarjetaDAO.agregarPago(pagoPorTarjeta);
        } catch (PersistenciaException ex) {
            Logger.getLogger(PagoBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<ProductoDTO> consultarProductosCompradosPorUsuario(String nombreUsuario) {
        try {
            List<Producto> productos = pagoDAO.consultarProductosCompradosPorUsuario(nombreUsuario);
            List<ProductoDTO> productosDTO = new ArrayList<>();

            // Convertir Productos a ProductosDTO
            for (Producto producto : productos) {
                ProductoDTO productoDTO = new ProductoDTO();
                productoDTO.setIsbn(producto.getIsbn());
                productoDTO.setTitulo(producto.getTitulo());
                productoDTO.setAutor(producto.getAutor());
                productoDTO.setTipo(producto.getTipo());
                productoDTO.setEditorial(producto.getEditorial());
                productoDTO.setPrecio(producto.getPrecio());
                productoDTO.setCategoria(producto.getCategoria());
                productoDTO.setCantidad(producto.getCantidad());
                // Puedes convertir las reseñas aquí si es necesario
                productosDTO.add(productoDTO);
            }

            return productosDTO;
        } catch (PersistenciaException ex) {
            Logger.getLogger(PagoBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
   
  public List<Object> consultarHistorialComprasPorUsuario(String nombreUsuario){
      try {
          return pagoDAO.consultarHistorialComprasPorUsuario(nombreUsuario);
      } catch (Exception e) {
      }
        return null;
  }
  
   public List<Object> consultarHistorialComprasPorUsuarioMeses(String nombreUsuario, int anio, int mes){
      try {
          return pagoDAO.consultarHistorialComprasPorUsuarioMeses(nombreUsuario, anio, mes);
      } catch (Exception e) {
      }
        return null;
  }
}
    
