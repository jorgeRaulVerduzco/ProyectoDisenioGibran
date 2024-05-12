/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IDAO;

import Dominio.PagoPorOxxo;
import Excepciones.PersistenciaException;

/**
 *
 * @author INEGI
 */
public interface IPagoPorOxxoDAO {
    public void agregarPago(PagoPorOxxo pago) throws PersistenciaException;
}
