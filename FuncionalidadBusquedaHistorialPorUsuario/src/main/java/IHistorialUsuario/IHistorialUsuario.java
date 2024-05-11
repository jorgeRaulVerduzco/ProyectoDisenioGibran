/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IHistorialUsuario;

import DTO.PagoDTO;
import java.util.List;

/**
 *
 * @author Bell
 */
public interface IHistorialUsuario {
       public List<Object> consultarHistorialComprasPorUsuarioMeses(String nombreUsuario, int anio, int meses);
}
