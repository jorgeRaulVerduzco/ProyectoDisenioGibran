/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IDAO;

import Dominio.Reseña;
import Excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author INEGI
 */
public interface IReseñaDAO {
      public void generarReseña(Reseña reseña) throws PersistenciaException;
      public List<Object> obtenerReseñasDeProducto(int isbn) throws PersistenciaException;
}
