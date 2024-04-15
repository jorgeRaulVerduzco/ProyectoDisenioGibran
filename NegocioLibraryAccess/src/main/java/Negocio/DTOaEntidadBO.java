/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DTO.PagoDTO;
import DTO.PagoPorOxxoDTO;
import DTO.PagoPorTarjetaDTO;
import DTO.ProductoDTO;
import DTO.TicketDTO;
import DTO.UsuarioDTO;
import Dominio.Pago;
import Dominio.PagoPorOxxo;
import Dominio.PagoPorTarjeta;
import Dominio.Producto;
import Dominio.Ticket;
import Dominio.Usuario;
import INegocio.iDTOaEntidadbo;

/**
 *
 * @author INEGI
 */
public class DTOaEntidadBO implements iDTOaEntidadbo {

    @Override
    public Producto ConvertirProductoDTO(ProductoDTO productoDTO) {
        Producto producto = new Producto();
        producto.setIsbn(productoDTO.getIsbn());
        producto.setTitulo(productoDTO.getTitulo());
        producto.setAutor(productoDTO.getAutor());
        producto.setTipo(productoDTO.getTipo());
        producto.setEditorial(productoDTO.getEditorial());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setValoracion(productoDTO.getValoracion());
        producto.setCategoria(productoDTO.getCategoria());
        producto.setCantidad(productoDTO.getCantidad());
        return producto;
    }

    @Override
    public Usuario ConvertirUsuarioDTO(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(usuarioDTO.getNombreUsuario());
        usuario.setContraseña(usuarioDTO.getContraseña());
        return usuario;
    }

    @Override
    public Pago ConvertirPagoDTO(PagoDTO pagoDTO) {
        Usuario usuario = this.ConvertirUsuarioDTO(pagoDTO.getUsuario());
        Producto producto = this.ConvertirProductoDTO(pagoDTO.getProducto());

        Pago pago = new Pago();
        pago.setIdPago(pagoDTO.getIdPago());
        pago.setUsuario(usuario);
        pago.setProducto(producto);
        pago.setCantidad(pagoDTO.getCantidad());
        pago.setMetodoPago(pagoDTO.getMetodoPago());
        pago.setCostoTotal(pagoDTO.getCostoTotal());

        return pago;
    }

    @Override
    public PagoPorOxxo ConnvertirPagoOxxoDTO(PagoPorOxxoDTO pagoOxxoDTO) {
        Usuario usuario = this.ConvertirUsuarioDTO(pagoOxxoDTO.getUsuario());
        Producto producto = this.ConvertirProductoDTO(pagoOxxoDTO.getProducto());

        PagoPorOxxo pagoOxxo = new PagoPorOxxo(usuario, producto, pagoOxxoDTO.getCantidad(), pagoOxxoDTO.getCostoTotal(), pagoOxxoDTO.getCodigoBarrasOxxo());

        return pagoOxxo;
    }

    @Override
    public PagoPorTarjeta convertirPagoPorTarjetaDTO(PagoPorTarjetaDTO pagoPorTarjetaDTO) {
        Usuario usuario = this.ConvertirUsuarioDTO(pagoPorTarjetaDTO.getUsuario());
        Producto producto = this.ConvertirProductoDTO(pagoPorTarjetaDTO.getProducto());

        PagoPorTarjeta pagoPorTarjeta = new PagoPorTarjeta(usuario, producto, pagoPorTarjetaDTO.getCantidad(), pagoPorTarjetaDTO.getCostoTotal(), pagoPorTarjetaDTO.getTipoTarjeta(), pagoPorTarjetaDTO.getNumeroTarjeta(), pagoPorTarjetaDTO.getFechaExpiracion(), pagoPorTarjetaDTO.getCodigoSeguridad());

        return pagoPorTarjeta;
    }

    @Override
    public Ticket convertirTicketDTO(TicketDTO ticketDTO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
