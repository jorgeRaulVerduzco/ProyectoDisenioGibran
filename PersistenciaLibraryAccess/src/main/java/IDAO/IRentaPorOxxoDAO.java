/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IDAO;

import Dominio.RentaPorOxxo;
import Excepciones.PersistenciaException;

/**
 *
 * @author rober
 */
public interface IRentaPorOxxoDAO {
    public void agregarRenta(RentaPorOxxo renta)throws PersistenciaException ;
}
