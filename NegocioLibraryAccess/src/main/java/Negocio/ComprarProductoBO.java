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
import Dominio.Pago;
import Dominio.PagoPorOxxo;
import Dominio.PagoPorTarjeta;
import Dominio.Producto;
import Excepciones.PersistenciaException;
import IDAO.IPagoDAO;
import IDAO.IPagoPorOxxoDAO;
import IDAO.IPagoPorTarjetaDAO;
import INegocio.IComprarProductoBO;

/**
 *
 * @author INEGI
 */
public class ComprarProductoBO implements IComprarProductoBO {

    IPagoDAO pagoDAO;
    IPagoPorOxxoDAO pagoPorOxxoDAO;
    DTOaEntidadBO dtoAentidad;
    IPagoPorTarjetaDAO pagoPorTarjetaDAO;

    public ComprarProductoBO() {
        pagoDAO = new PagoDAO();
        dtoAentidad = new DTOaEntidadBO();
        pagoPorOxxoDAO = new PagoPorOxxoDAO();
        pagoPorTarjetaDAO = new PagoPorTarjetaDAO();
    }

    @Override
    public void ComprarProducto(PagoDTO pagoDTO) throws PersistenciaException {
       Pago pago = dtoAentidad.ConvertirPagoDTO(pagoDTO);

    Producto producto = pago.getProducto().get(0);

    double precioProducto = producto.getPrecio();

    int cantidad = pago.getCantidad();

    double costoTotal = precioProducto * cantidad;

    pago.setCostoTotal(costoTotal);

    pagoDAO.agregarPago(pago);
    }

    @Override
    public void ComprarProductoPorOxxo(PagoPorOxxoDTO pagoPorOxxoDTO) throws PersistenciaException {
        PagoPorOxxo pagoPorOxxo = dtoAentidad.ConnvertirPagoOxxoDTO(pagoPorOxxoDTO);

        pagoPorOxxoDAO.agregarPago(pagoPorOxxo);
    }

    @Override
    public void ComprarProductoPorTarjeta(PagoPorTarjetaDTO pagoPorTarjetaDTO) throws PersistenciaException {
        PagoPorTarjeta pagoPorTarjeta = dtoAentidad.convertirPagoPorTarjetaDTO(pagoPorTarjetaDTO);

        pagoPorTarjetaDAO.agregarPago(pagoPorTarjeta);
    }
}
