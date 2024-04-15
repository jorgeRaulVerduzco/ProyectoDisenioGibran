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
import IDAO.IPagoDAO;
import IDAO.IPagoPorOxxoDAO;
import IDAO.IPagoPorTarjetaDAO;
import INegocio.IComprarProductoBO;

/**
 *
 * @author INEGI
 */
public class ComprarProductoBO implements IComprarProductoBO{

    IPagoDAO pagoDAO;
    IPagoPorOxxoDAO pagoPorOxxoDAO;
    DTOaEntidadBO dtoAentidad;
    IPagoPorTarjetaDAO pagoPorTarjetaDAO;

    public ComprarProductoBO() {
        pagoDAO = PagoDAO.getInstancia();
        dtoAentidad = new DTOaEntidadBO();
        pagoPorOxxoDAO = PagoPorOxxoDAO.getInstancia();
        pagoPorTarjetaDAO = PagoPorTarjetaDAO.getInstancia();
    }

    @Override
    public void ComprarProducto(PagoDTO pagoDTO) {
        Pago pago = dtoAentidad.ConvertirPagoDTO(pagoDTO);

        double precioProducto = pago.getProducto().getPrecio();

        int cantidad = pago.getCantidad();

        double costoTotal = precioProducto * cantidad;

        pago.setCostoTotal(costoTotal);

        pagoDAO.agregarPago(pago);
    }

    @Override
    public void ComprarProductoPorOxxo(PagoPorOxxoDTO pagoPorOxxoDTO) {
        PagoPorOxxo pagoPorOxxo = dtoAentidad.ConnvertirPagoOxxoDTO(pagoPorOxxoDTO);

        double precioProducto = pagoPorOxxo.getProducto().getPrecio();

        int cantidad = pagoPorOxxo.getCantidad();

        double costoTotal = precioProducto * cantidad;

        pagoPorOxxo.setCostoTotal(costoTotal);

        pagoPorOxxoDAO.agregarPago(pagoPorOxxo);
    }

    @Override
    public void ComprarProductoPorTarjeta(PagoPorTarjetaDTO pagoPorTarjetaDTO) {
        PagoPorTarjeta pagoPorTarjeta = dtoAentidad.convertirPagoPorTarjetaDTO(pagoPorTarjetaDTO);

        double precioProducto = pagoPorTarjeta.getProducto().getPrecio();

        int cantidad = pagoPorTarjeta.getCantidad();

        double costoTotal = precioProducto * cantidad;

        pagoPorTarjeta.setCostoTotal(costoTotal);

        pagoPorTarjetaDAO.agregarPago(pagoPorTarjeta);
    }
}
