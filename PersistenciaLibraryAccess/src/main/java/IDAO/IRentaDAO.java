/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IDAO;

import Dominio.Producto;
import Dominio.Renta;
import Excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author rober
 */
public interface IRentaDAO {

    public void agregarPago(Renta renta) throws PersistenciaException;

    public List<Producto> consultarProductosRentadosPorUsuario(String nombreUsuario) throws PersistenciaException;
    
    public List<Renta> consultarHistorialRentas(String nombreUsuario) throws PersistenciaException;

}
