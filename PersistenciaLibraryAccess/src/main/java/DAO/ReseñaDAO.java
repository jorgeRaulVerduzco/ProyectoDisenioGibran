/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.ConexionBD;
import Dominio.Producto;
import Dominio.Reseña;
import Excepciones.PersistenciaException;
import IDAO.IReseñaDAO;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.Projections;
import static com.mongodb.client.model.Updates.set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author INEGI
 */
public class ReseñaDAO implements IReseñaDAO {

    private final MongoCollection<Reseña> coleccionReseña;
    private final MongoCollection<Producto> coleccionProducto;

    public ReseñaDAO() {

        this.coleccionReseña = ConexionBD.getDatabase().getCollection("Reseña", Reseña.class);
        this.coleccionProducto = ConexionBD.getDatabase().getCollection("Producto", Producto.class);

    }

    @Override
    public void generarReseña(Reseña reseña) throws PersistenciaException {
       try {
        Reseña reseñaExistente = coleccionReseña.find(and(eq("producto.isbn", reseña.getProducto().getIsbn()), eq("usuario.nombreUsuario", reseña.getUsuario().getNombreUsuario()))).first();
        if (reseñaExistente != null) {
            reseñaExistente.setRating(reseña.getRating());
            reseñaExistente.setReseña(reseña.getReseña());
            coleccionReseña.replaceOne(and(eq("producto.isbn", reseña.getProducto().getIsbn()), eq("usuario.nombreUsuario", reseña.getUsuario().getNombreUsuario())), reseñaExistente);
        } else {
            coleccionReseña.insertOne(reseña);
        }
        
        int isbnProducto = reseña.getProducto().getIsbn();
        Producto producto = coleccionProducto.find(eq("isbn", isbnProducto)).first();
        if (producto != null) {
            List<Reseña> reseñasActualizadas = producto.getReseñas();
            Reseña reseñaUsuario = reseñasActualizadas.stream().filter(r -> r.getUsuario().getNombreUsuario().equals(reseña.getUsuario().getNombreUsuario())).findFirst().orElse(null);
            if (reseñaUsuario != null) {
                reseñaUsuario.setRating(reseña.getRating());
                reseñaUsuario.setReseña(reseña.getReseña());
            } else {
                reseñasActualizadas.add(reseña);
            }
            coleccionProducto.updateOne(eq("isbn", isbnProducto), set("reseñas", reseñasActualizadas));
        }
    } catch (Exception e) {
        throw new PersistenciaException("Error al generar reseña: " + e.getMessage());
    }
    }

    @Override
   public List<Object> obtenerReseñasDeProducto(int isbn) throws PersistenciaException {
        try {
            Bson filtroISBN = Filters.eq("producto.isbn", isbn);

            List<Bson> pipeline = Arrays.asList(
                    Aggregates.match(filtroISBN),
                    Aggregates.project(Projections.fields(
                            Projections.include("usuario.nombreUsuario", "reseña", "rating")
                    ))
            );

            List<Document> documentosReseñas = new ArrayList<>(coleccionReseña.aggregate(pipeline, Document.class).into(new ArrayList<>()));

            List<Object> reseñas = new ArrayList<>();
            for (Document documento : documentosReseñas) {
                Map<String, Object> reseñaMap = new HashMap<>();
                reseñaMap.put("nombreUsuario", documento.get("usuario", Document.class).getString("nombreUsuario"));
                reseñaMap.put("reseña", documento.getString("reseña"));
                reseñaMap.put("rating", documento.getInteger("rating"));
                reseñas.add(reseñaMap);
            }

            return reseñas;
        } catch (MongoException e) {
            throw new PersistenciaException("Error al obtener las reseñas del producto: " + e.getMessage());
        }
    }


   

  
    
    
}
