/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IDAO;

import Dominio.RentaPorTarjeta;
import Excepciones.PersistenciaException;

/**
 *
 * @author rober
 */
public interface IRentaPorTarjetaDAO {
    public void agregarRenta(RentaPorTarjeta renta) throws PersistenciaException;
}
