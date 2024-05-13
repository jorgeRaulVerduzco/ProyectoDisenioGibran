/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package INegocio;

import DTO.ProductoDTO;
import DTO.UsuarioDTO;
import java.util.List;

/**
 *
 * @author INEGI
 */
public interface IUsuarioBO {

    public void agregarUsuario(UsuarioDTO usuarioDTO);

    public boolean buscarUsuario(String nombreUsuario, String contraseña);

    public UsuarioDTO UsuarioInicioSesion(String nombreUsuario, String contraseña);

    public void agregarProductoVendido(String nombreUsuario, ProductoDTO productoVendido);

    public List<ProductoDTO> obtenerHistorialProductosVendidos(String nombreUsuario);
}
