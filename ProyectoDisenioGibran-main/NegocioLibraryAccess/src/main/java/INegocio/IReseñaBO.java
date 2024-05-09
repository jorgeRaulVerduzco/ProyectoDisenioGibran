/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package INegocio;

import DTO.ReseñaDTO;
import java.util.List;

/**
 *
 * @author INEGI
 */
public interface IReseñaBO {
     public void generarReseña(ReseñaDTO reseñaDTO);
     
       public List<Object> obtenerReseñasDeProducto(int isbn) ;
}
