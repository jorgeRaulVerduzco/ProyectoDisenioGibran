/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IProductosDelUsuario;

import DTO.ProductoDTO;
import java.util.List;

/**
 *
 * @author INEGI
 */
public interface IProductosUsuario {
public List<ProductoDTO> consultarProductosCompradosPorUsuario(String nombreUsuario);

}
