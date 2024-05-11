/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IProductosVendidos;

import DTO.ProductoDTO;
import java.util.List;

public interface IListaProductosVendidos {

    public List<ProductoDTO> buscarProductosPorVendedor(String vendedor);
}
