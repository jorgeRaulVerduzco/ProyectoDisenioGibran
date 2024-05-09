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
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.UnwindOptions;
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

    @Override
   public List<Producto> consultarProductosCompradosPorUsuario(String nombreUsuario) throws PersistenciaException {
    try {
        Bson filtroUsuario = Filters.elemMatch("usuario", Filters.eq("nombreUsuario", nombreUsuario));

        List<Bson> pipeline = Arrays.asList(
                Aggregates.match(filtroUsuario),
                Aggregates.unwind("$producto"), 
                Aggregates.group("$producto.isbn",
                        Accumulators.first("titulo", "$producto.titulo"),
                        Accumulators.first("autor", "$producto.autor"),
                        Accumulators.first("tipo", "$producto.tipo"),
                        Accumulators.first("editorial", "$producto.editorial"),
                        Accumulators.first("precio", "$producto.precio"),
                        Accumulators.first("categoria", "$producto.categoria")
                )
        );

        List<Document> documentosProductos = new ArrayList<>(coleccionPago.aggregate(pipeline, Document.class).into(new ArrayList<>()));

        List<Producto> productosComprados = new ArrayList<>();
        for (Document documento : documentosProductos) {
            Producto producto = new Producto();
            producto.setIsbn(documento.getInteger("_id"));
            producto.setTitulo(documento.getString("titulo"));
            producto.setAutor(documento.getString("autor"));
            producto.setTipo(documento.getString("tipo"));
            producto.setEditorial(documento.getString("editorial"));
            producto.setPrecio(documento.getDouble("precio"));
            producto.setCategoria(documento.getString("categoria"));
            productosComprados.add(producto);
        }

        return productosComprados;
    } catch (MongoException e) {
        throw new PersistenciaException("Error al consultar productos comprados por el usuario: " + e.getMessage());
    }
  }
}
  