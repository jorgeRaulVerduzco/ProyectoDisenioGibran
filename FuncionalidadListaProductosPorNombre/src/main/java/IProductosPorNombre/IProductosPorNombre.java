/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IProductosPorNombre;

import DTO.ProductoDTO;
import java.util.List;

/**
 *
 * @author INEGI
 */
public interface IProductosPorNombre {
    public List<ProductoDTO> buscarProductosPorNombre(String nombre);
}
