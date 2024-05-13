/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProductosVendidos;

import DTO.ProductoDTO;
import INegocio.IProductoBO;
import IProductosVendidos.IListaProductosVendidos;
import Negocio.ProductoBO;
import Negocio.UsuarioBO;
import java.util.List;

public class ProductosVendidos implements IListaProductosVendidos {
UsuarioBO usuarioBO;
    public ProductosVendidos() {
        
        usuarioBO = new UsuarioBO();
    }


@Override
    public List<ProductoDTO> buscarProductosPorVendedor(String vendedor){
        return usuarioBO.obtenerHistorialProductosVendidos(vendedor);
    }

    

}
