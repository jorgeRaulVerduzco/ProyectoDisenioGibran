/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.ConexionBD;
import Dominio.Pago;
import Dominio.Producto;
import Dominio.Renta;
import Excepciones.PersistenciaException;
import IDAO.IRentaDAO;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import java.util.List;

/**
 *
 * @author Roberto Verdugo Beltran
 */
public class RentaDAO implements IRentaDAO {

    private final MongoCollection<Renta> coleccionRenta;

    public RentaDAO() {
        this.coleccionRenta = ConexionBD.getDatabase().getCollection("Renta", Renta.class);
    }

    @Override
    public void agregarPago(Renta renta) throws PersistenciaException {
        try {
            coleccionRenta.insertOne(renta);
            for (Producto producto : renta.getProducto()) {
                producto.restarCantidad(renta.getCantidad());
            }
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo insertar la renta: " + e.getMessage());
        }
    }

    @Override
    public List<Producto> consultarProductosRentadosPorUsuario(String nombreUsuario) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Renta> consultarHistorialRentas(String nombreUsuario) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
