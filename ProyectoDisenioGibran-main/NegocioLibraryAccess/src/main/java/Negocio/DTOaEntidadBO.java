/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DTO.PagoDTO;
import DTO.PagoPorOxxoDTO;
import DTO.PagoPorTarjetaDTO;
import DTO.ProductoDTO;
import DTO.ReseñaDTO;
import DTO.TicketDTO;
import DTO.UsuarioDTO;
import Dominio.Pago;
import Dominio.PagoPorOxxo;
import Dominio.PagoPorTarjeta;
import Dominio.Producto;
import Dominio.Reseña;
import Dominio.Ticket;
import Dominio.Usuario;
import INegocio.iDTOaEntidadbo;
import java.util.ArrayList;
import java.util.List;

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
        producto.setCategoria(productoDTO.getCategoria());
        producto.setCantidad(productoDTO.getCantidad());
      if (productoDTO.getReseñas() != null) {
        List<ReseñaDTO> reseñasDTO = productoDTO.getReseñas();
        List<Reseña> reseñas = new ArrayList<>();
        for (ReseñaDTO reseñaDTO : reseñasDTO) {
            Reseña reseña = convertirReseñaDTO(reseñaDTO);
            reseñas.add(reseña);
        }
        producto.setReseñas(reseñas);
    }
        return producto;
    }

    @Override
    public Usuario ConvertirUsuarioDTO(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(usuarioDTO.getNombreUsuario());
        usuario.setContraseña(usuarioDTO.getContraseña());

        List<Producto> productos = new ArrayList<>();
        for (ProductoDTO productoDTO : usuarioDTO.getProductos()) {
            Producto producto = ConvertirProductoDTO(productoDTO);
            productos.add(producto);
        }
        usuario.setProductosVendidos(productos);
        return usuario;
    }

    @Override
    public Pago ConvertirPagoDTO(PagoDTO pagoDTO) {
        Pago pago = new Pago();
        pago.setCantidad(pagoDTO.getCantidad());
        pago.setCostoTotal(pagoDTO.getCostoTotal());
        pago.setFechaDePago(pagoDTO.getFechaDePago());
        List<Usuario> usuarios = new ArrayList<>();
        for (UsuarioDTO usuarioDTO : pagoDTO.getUsuarioDTO()) {
            Usuario usuario = ConvertirUsuarioDTO(usuarioDTO);
            usuarios.add(usuario);
        }
        pago.setUsuario(usuarios);

        List<Producto> productos = new ArrayList<>();
        for (ProductoDTO productoDTO : pagoDTO.getProductoDTO()) {
            Producto producto = ConvertirProductoDTO(productoDTO);
            productos.add(producto);
        }
        pago.setProducto(productos);

        // Convertir lista de PagoPorOxxoDTO a lista de PagoPorOxxo
        List<PagoPorOxxo> pagoPorOxxos = new ArrayList<>();
        for (PagoPorOxxoDTO pagoPorOxxoDTO : pagoDTO.getPagoPorOxxoDTO()) {
            PagoPorOxxo pagoPorOxxo = ConnvertirPagoOxxoDTO(pagoPorOxxoDTO);
            pagoPorOxxos.add(pagoPorOxxo);
        }
        pago.setPagoPorOxxo(pagoPorOxxos);

        // Convertir lista de PagoPorTarjetaDTO a lista de PagoPorTarjeta
        List<PagoPorTarjeta> pagoPorTarjetas = new ArrayList<>();
        for (PagoPorTarjetaDTO pagoPorTarjetaDTO : pagoDTO.getPagoPorTarjetaDTO()) {
            PagoPorTarjeta pagoPorTarjeta = convertirPagoPorTarjetaDTO(pagoPorTarjetaDTO);
            pagoPorTarjetas.add(pagoPorTarjeta);
        }
        pago.setPagoPorTarjeta(pagoPorTarjetas);

        return pago;
    }

    @Override
    public PagoPorOxxo ConnvertirPagoOxxoDTO(PagoPorOxxoDTO pagoOxxoDTO) {
        PagoPorOxxo pagoOxxo = new PagoPorOxxo();
        pagoOxxo.setCodigoBarrasOxxo(pagoOxxoDTO.getCodigoBarrasOxxo());
        return pagoOxxo;
    }

    @Override
    public PagoPorTarjeta convertirPagoPorTarjetaDTO(PagoPorTarjetaDTO pagoPorTarjetaDTO) {
        PagoPorTarjeta pagoTarjeta = new PagoPorTarjeta();
        pagoTarjeta.setCodigoSeguridad(pagoPorTarjetaDTO.getCodigoSeguridad());
        pagoTarjeta.setFechaExpiracion(pagoPorTarjetaDTO.getFechaExpiracion());
        pagoTarjeta.setNumeroTarjeta(pagoPorTarjetaDTO.getNumeroTarjeta());
        pagoTarjeta.setTipoTarjeta(pagoPorTarjetaDTO.getTipoTarjeta());

        return pagoTarjeta;
    }

    @Override
    public Ticket convertirTicketDTO(TicketDTO ticketDTO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Reseña convertirReseñaDTO(ReseñaDTO reseñaDTO) {
        Reseña reseña = new Reseña();
        reseña.setReseña(reseñaDTO.getReseña());
        reseña.setRating(reseñaDTO.getRating());

        // Convertir el ProductoDTO a Producto
        Producto producto = ConvertirProductoDTO(reseñaDTO.getProducto());
        reseña.setProducto(producto);

        // Convertir el UsuarioDTO a Usuario
        Usuario usuario = ConvertirUsuarioDTO(reseñaDTO.getUsuario());
        reseña.setUsuario(usuario);

        return reseña;
    }

}
