package Negocio;

import DTO.PagoDTO;
import DTO.ProductoDTO;
import IDAO.IPagoDAO;
import java.util.List;
import DAO.CompraDAO;
import DTO.UsuarioDTO;
import Dominio.Pago;
import Dominio.Producto;
import Dominio.Usuario;
import Excepciones.PersistenciaException;
import IDAO.ICompraDAO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bell
 */
public class CompraBO {
//
//    ICompraDAO pagoDao;
//    DTOaEntidadBO dtoaAentidad;
//
//    public CompraBO() {
//        pagoDao = new CompraDAO();
//        dtoaAentidad = new DTOaEntidadBO();
//    }
//
//    public List<UsuarioDTO> buscarUsuario(String usuario) {
//        
//        try {
//            List<Pago> pagos = pagoDao.BuscarUsuario(usuario);
//            List<UsuarioDTO> usuariodtos = new ArrayList<>();
//
//            for (Pago pago : pagos) {
//               Usuario usuariodto = ConvertirAUsuarioDTO((UsuarioDTO) pagos);
//                usuariodtos.add(usuariodto);
//            }
//
//            return usuariodtos;
//        } catch (PersistenciaException ex) {
//            Logger.getLogger(CompraBO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//    
//     public Usuario ConvertirAUsuarioDTO(UsuarioDTO usuarioDTO) {
//        Usuario usuario = new Usuario();
//        usuario.setNombreUsuario(usuarioDTO.getNombreUsuario());
//        usuario.setContraseña(usuarioDTO.getContraseña());
//        
//        List<Producto> productos = new ArrayList<>();
//        for (ProductoDTO productoDTO : usuarioDTO.getProductos()) {
//            Producto producto = ConvertirProductoDTO(productoDTO);
//            productos.add(producto);
//        }
//        usuario.setProductosVendidos(productos);
//        return usuario;
//    }
//    public Producto ConvertirProductoDTO(ProductoDTO productoDTO) {
//        Producto producto = new Producto();
//        producto.setIsbn(productoDTO.getIsbn());
//        producto.setTitulo(productoDTO.getTitulo());
//        producto.setAutor(productoDTO.getAutor());
//        producto.setTipo(productoDTO.getTipo());
//        producto.setEditorial(productoDTO.getEditorial());
//        producto.setPrecio(productoDTO.getPrecio());
//        producto.setCategoria(productoDTO.getCategoria());
//        producto.setCantidad(productoDTO.getCantidad());
//        return producto;
//    }
 }


