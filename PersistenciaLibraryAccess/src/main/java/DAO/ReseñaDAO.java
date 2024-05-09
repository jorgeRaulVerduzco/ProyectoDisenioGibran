/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.ConexionBD;
import Dominio.Producto;
import Dominio.Reseña;
import Excepciones.PersistenciaException;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author INEGI
 */
public class ReseñaDAO {

    private final MongoCollection<Reseña> coleccionReseña;
    private final MongoCollection<Producto> coleccionProducto;

    public ReseñaDAO() {

        this.coleccionReseña = ConexionBD.getDatabase().getCollection("Reseña", Reseña.class);
        this.coleccionProducto = ConexionBD.getDatabase().getCollection("Producto", Producto.class);

    }

    public void generarReseña(Reseña reseña) throws PersistenciaException {
        try {
            coleccionReseña.insertOne(reseña);
            int isbnProducto = reseña.getProducto().getIsbn();
            Producto producto = coleccionProducto.find(eq("isbn", isbnProducto)).first();
            if (producto != null) {
                List<Reseña> reseñasActualizadas = producto.getReseñas();
                reseñasActualizadas.add(reseña);
                coleccionProducto.updateOne(eq("isbn", isbnProducto), set("reseñas", reseñasActualizadas));
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al generar reseña: " + e.getMessage());
        }
    }



    public List<Reseña> reseñasPorProducto(String isbn) throws PersistenciaException{
        List<Reseña> reseñasDelProducto = new ArrayList<>();
        reseñasDelProducto = coleccionReseña.find(eq("producto.isbn", isbn)).into(new ArrayList<>());
        return reseñasDelProducto;
    }

  
    
    
}
