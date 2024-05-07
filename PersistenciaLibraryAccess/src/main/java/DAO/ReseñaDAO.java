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
        coleccionReseña.insertOne(reseña); // Inserta la reseña en la colección
        int isbnProducto = reseña.getProducto().getIsbn(); // Obtiene el ISBN del producto asociado
        Producto producto = coleccionProducto.find(eq("isbn", isbnProducto)).first(); // Encuentra el producto por ISBN
        if (producto != null) {
            List<Reseña> reseñasActualizadas = producto.getReseñas();
            reseñasActualizadas.add(reseña); // Añade la nueva reseña a la lista
            coleccionProducto.updateOne(eq("isbn", isbnProducto), set("reseñas", reseñasActualizadas)); // Actualiza el producto
        }
    } catch (Exception e) {
        throw new PersistenciaException("Error al generar reseña: " + e.getMessage());
    }
   }
}
