/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.ConexionBD;
import Dominio.RentaPorOxxo;
import Excepciones.PersistenciaException;
import IDAO.IRentaPorOxxoDAO;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;

/**
 *
 * @author rober
 */
public class RentaPorOxxoDAO implements IRentaPorOxxoDAO {

    private final MongoCollection<RentaPorOxxo> coleccionRentaOxxo;

    public RentaPorOxxoDAO() {
        this.coleccionRentaOxxo = ConexionBD.getDatabase().getCollection("RentaPorOxxo", RentaPorOxxo.class);
    }

    @Override
    public void agregarRenta(RentaPorOxxo renta) throws PersistenciaException {
        try {
            this.coleccionRentaOxxo.insertOne(renta);
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo insertar la renta por Oxxo: " + e.getMessage());
        }
    }

}
