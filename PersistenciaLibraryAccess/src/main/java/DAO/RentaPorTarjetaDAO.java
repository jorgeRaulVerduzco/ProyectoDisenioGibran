/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.ConexionBD;
import Dominio.RentaPorTarjeta;
import Excepciones.PersistenciaException;
import IDAO.IRentaPorTarjetaDAO;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;

/**
 *
 * @author rober
 */
public class RentaPorTarjetaDAO implements IRentaPorTarjetaDAO {

    private final MongoCollection<RentaPorTarjeta> coleccionRentaTarjeta;

    public RentaPorTarjetaDAO() {
        this.coleccionRentaTarjeta = ConexionBD.getDatabase().getCollection("RentaPorTarjeta", RentaPorTarjeta.class);
    }

    @Override
    public void agregarRenta(RentaPorTarjeta RentaPorTarjeta) throws PersistenciaException {
        try {
            this.coleccionRentaTarjeta.insertOne(RentaPorTarjeta);

        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo insertar al pago: ");
        }
    }
}
