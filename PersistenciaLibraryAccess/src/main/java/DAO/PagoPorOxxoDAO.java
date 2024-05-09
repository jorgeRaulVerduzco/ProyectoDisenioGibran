/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.ConexionBD;
import Dominio.PagoPorOxxo;
import Excepciones.PersistenciaException;
import IDAO.IPagoPorOxxoDAO;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import org.bson.types.ObjectId;


/**
 *
 * @author INEGI
 */
public class PagoPorOxxoDAO implements IPagoPorOxxoDAO{
      private final MongoCollection<PagoPorOxxo> coleccionPagoOxxo;

    public PagoPorOxxoDAO() {
            this.coleccionPagoOxxo =  ConexionBD.getDatabase().getCollection("PagoPorOxxo", PagoPorOxxo.class);
    }


    @Override
    public void agregarPago(PagoPorOxxo pago) throws PersistenciaException {
        try {
            this.coleccionPagoOxxo.insertOne(pago);
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo insertar el pago por Oxxo: " + e.getMessage());
        }
    }
}
