/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IVenderProducto;

import DTO.ProductoDTO;

/**
 *
 * @author INEGI
 */
public interface IVenderProducto {
     public void agregarProductoVendido(String nombreUsuario, ProductoDTO productoVendido);
}
