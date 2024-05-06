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
    public void agregarPago(PagoPorTarjeta pago) throws PersistenciaException {
        try {
            this.coleccionPagoTarjeta.insertOne(pago);
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo insertar al pago: ");
        }
    }
}
