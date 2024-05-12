/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAO.RentaDAO;
import DAO.RentaPorOxxoDAO;
import DAO.RentaPorTarjetaDAO;
import DTO.ProductoDTO;
import DTO.RentaDTO;
import DTO.RentaPorOxxoDTO;
import DTO.RentaPorTarjetaDTO;
import Dominio.Producto;
import Dominio.Renta;
import Dominio.RentaPorOxxo;
import Dominio.RentaPorTarjeta;
import Excepciones.PersistenciaException;
import IDAO.IRentaDAO;
import IDAO.IRentaPorOxxoDAO;
import IDAO.IRentaPorTarjetaDAO;
import INegocio.IRentaBO;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rober
 */
public class RentaBO implements IRentaBO {

    IRentaDAO rentaDAO;
    IRentaPorOxxoDAO rentaPorOxxoDAO;
    DTOaEntidadBO dtoAentidad;
    IRentaPorTarjetaDAO rentaPorTarjetaDAO;

    public RentaBO() {
        rentaDAO = new RentaDAO();
        dtoAentidad = new DTOaEntidadBO();
        rentaPorOxxoDAO = new RentaPorOxxoDAO();
        rentaPorTarjetaDAO = new RentaPorTarjetaDAO();
    }

    @Override
    public void rentarProducto(RentaDTO rentaDTO) {
        Renta renta = dtoAentidad.convertirRentaDTO(rentaDTO);

        Producto producto = renta.getProducto().get(0);

        double precioProducto = producto.getPrecio();

        int cantidad = renta.getCantidad();

        double costoTotal = precioProducto * cantidad;
        renta.setCostoRenta(costoTotal);

        Date fechaRenta = renta.getFechaRenta();

        Date fechaDevolucion = renta.getFechaDevolucion();

        try {
            rentaDAO.agregarPago(renta);
        } catch (PersistenciaException ex) {
            Logger.getLogger(PagoBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void rentarProductoPorOxxo(RentaPorOxxoDTO rentaPorOxxoDTO) {
        RentaPorOxxo rentaPorOxxo = dtoAentidad.convertitRentaOxxoDTO(rentaPorOxxoDTO);

        try {
            rentaPorOxxoDAO.agregarRenta(rentaPorOxxo);
        } catch (PersistenciaException ex) {
            Logger.getLogger(PagoBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void rentarProductoPorTarjeta(RentaPorTarjetaDTO rentaPorTarjetaDTO) {
        RentaPorTarjeta rentaPorTarjeta = dtoAentidad.convertitRentaPorTarjetaDTO(rentaPorTarjetaDTO);

        try {
            rentaPorTarjetaDAO.agregarRenta(rentaPorTarjeta);
        } catch (PersistenciaException ex) {
            Logger.getLogger(PagoBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<ProductoDTO> consultarPorductosRentadosPorUsuario(String nombreUsuario) {
        try {
            List<Producto> productos = rentaDAO.consultarProductosRentadosPorUsuario(nombreUsuario);
            List<ProductoDTO> productosDTO = new ArrayList<>();

            //Convertir = Productos a ProductosDTO
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

    @Override
    public List<Object> consultarHistorialRentasPorUsuario(String nombreUsuario) {
        try {
            return rentaDAO.consultarHistorialRentasPorUsuario(nombreUsuario);
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public List<Object> consultarHistorialRentasPorUsuarioMeses(String nombreUsuario, int anho, int mes) {
        try {
            return rentaDAO.consultarHistorialRentasPorUsuarioMeses(nombreUsuario, anho, mes);
        } catch (Exception e) {
        }
        return null;
    }

}
