/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.ConexionBD;
import Dominio.PagoPorTarjeta;
import Excepciones.PersistenciaException;
import IDAO.IPagoPorTarjetaDAO;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import org.bson.types.ObjectId;

/**
 *
 * @author INEGI
 */
public class PagoPorTarjetaDAO implements IPagoPorTarjetaDAO {

    private final MongoCollection<PagoPorTarjeta> coleccionPagoTarjeta;

    public PagoPorTarjetaDAO() {
        this.coleccionPagoTarjeta = ConexionBD.getDatabase().getCollection("PagoPorTarjeta", PagoPorTarjeta.class);
    }

    @Override
    public void agregarPago(PagoPorTarjeta pagoPorTarjeta) throws PersistenciaException {
        try {
            this.coleccionPagoTarjeta.insertOne(pagoPorTarjeta);
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo insertar al pago: ");
        }
    }
}
