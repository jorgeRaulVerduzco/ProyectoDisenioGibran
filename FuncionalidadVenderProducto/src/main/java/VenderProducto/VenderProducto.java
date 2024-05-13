/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VenderProducto;

import DTO.ProductoDTO;
import IVenderProducto.IVenderProducto;
import Negocio.UsuarioBO;

/**
 *
 * @author INEGI
 */
public class VenderProducto implements IVenderProducto {
    
    UsuarioBO usuarioBO;
    
    public VenderProducto() {
        usuarioBO = new UsuarioBO();
    }
    
    @Override
    public void agregarProductoVendido(String nombreUsuario, ProductoDTO productoVendido) {
        usuarioBO.agregarProductoVendido(nombreUsuario, productoVendido);
        
    }
    
}
