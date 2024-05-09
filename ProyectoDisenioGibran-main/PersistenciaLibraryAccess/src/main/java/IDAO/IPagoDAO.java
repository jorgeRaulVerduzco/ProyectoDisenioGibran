/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IDAO;

import Dominio.Pago;
import Dominio.Producto;
import Excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author INEGI
 */
public interface IPagoDAO {
    public void agregarPago(Pago pago) throws PersistenciaException ;
 public List<Producto> consultarProductosCompradosPorUsuario(String nombreUsuario) throws PersistenciaException;

}
