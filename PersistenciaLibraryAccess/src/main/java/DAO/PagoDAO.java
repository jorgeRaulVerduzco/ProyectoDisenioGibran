/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.ConexionBD;
import Dominio.Pago;
import Dominio.Producto;
import Excepciones.PersistenciaException;
import IDAO.IPagoDAO;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;

/**
 *
 * @author INEGI
 */
public class PagoDAO implements IPagoDAO {

    private final MongoCollection<Pago> coleccionPago;

    public PagoDAO() {
        this.coleccionPago = ConexionBD.getDatabase().getCollection("Pago", Pago.class);
    }

    @Override
    public void agregarPago(Pago pago) throws PersistenciaException {
        try {
            coleccionPago.insertOne(pago);
            for (Producto producto : pago.getProducto()) {
                producto.restarCantidad(pago.getCantidad());
            }
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo insertar el pago: " + e.getMessage());
        }
    }
}
