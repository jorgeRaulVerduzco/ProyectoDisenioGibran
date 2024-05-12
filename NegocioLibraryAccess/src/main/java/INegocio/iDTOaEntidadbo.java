/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package INegocio;

import DTO.*;
import Dominio.*;

/**
 *
 * @author INEGI
 */
public interface iDTOaEntidadbo {
    public  Producto ConvertirProductoDTO(ProductoDTO productoDTO);
    public Usuario ConvertirUsuarioDTO(UsuarioDTO usuarioDTO);
    
    public Pago ConvertirPagoDTO(PagoDTO pagoDTO);
    public PagoPorOxxo ConnvertirPagoOxxoDTO(PagoPorOxxoDTO pagoOxxoDTO);
    public PagoPorTarjeta convertirPagoPorTarjetaDTO(PagoPorTarjetaDTO PagoPorTarjetaDTO);
    
    public Ticket convertirTicketDTO(TicketDTO ticketDTO);
    
    public Renta convertirRentaDTO(RentaDTO rentaDTO);
    public RentaPorOxxo convertitRentaOxxoDTO(RentaPorOxxoDTO rentaPorOxxoDTO);
    public RentaPorTarjeta convertitRentaPorTarjetaDTO(RentaPorTarjetaDTO rentaPorTarjetaDTO);
}
