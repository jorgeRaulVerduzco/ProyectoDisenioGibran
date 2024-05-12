/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IProductosPorCategoria;

import DTO.ProductoDTO;
import java.util.List;

/**
 *
 * @author JORGE
 */
public interface IProductosPorCategoria {

    public List<ProductoDTO> buscarProductosPorCategoria(String categoria);
}
