/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.ConexionBD;
import Dominio.Producto;
import Dominio.Renta;
import Excepciones.PersistenciaException;
import IDAO.IRentaDAO;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author Roberto Verdugo Beltran
 */
public class RentaDAO implements IRentaDAO {

    private final MongoCollection<Renta> coleccionRenta;

    public RentaDAO() {
        this.coleccionRenta = ConexionBD.getDatabase().getCollection("Renta", Renta.class);
    }

    @Override
    public void agregarPago(Renta renta) throws PersistenciaException {
        try {
            coleccionRenta.insertOne(renta);
            for (Producto producto : renta.getProducto()) {
                producto.restarCantidad(renta.getCantidad());
            }
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo insertar la renta: " + e.getMessage());
        }
    }

    @Override
    public List<Producto> consultarProductosRentadosPorUsuario(String nombreUsuario) throws PersistenciaException {
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

            List<Document> documentosProductos = new ArrayList<>(coleccionRenta.aggregate(pipeline, Document.class).into(new ArrayList<>()));

            List<Producto> productosRentados = new ArrayList<>();
            for (Document documento : documentosProductos) {
                Producto producto = new Producto();
                producto.setIsbn(documento.getInteger("_id"));
                producto.setTitulo(documento.getString("titulo"));
                producto.setAutor(documento.getString("autor"));
                producto.setTipo(documento.getString("tipo"));
                producto.setEditorial(documento.getString("editorial"));
                producto.setPrecio(documento.getDouble("precio"));
                producto.setCategoria(documento.getString("categoria"));
                productosRentados.add(producto);
            }

            return productosRentados;
        } catch (MongoException e) {
            throw new PersistenciaException("Error al consultar productos rentados por el usuario: " + e.getMessage());
        }
    }

    @Override
    public List<Object> consultarHistorialRentasPorUsuario(String nombreUsuario) throws PersistenciaException {
        try {
            Bson filtroUsuario = Filters.elemMatch("usuario", Filters.eq("nombreUsuario", nombreUsuario));

            List<Bson> pipeline = Arrays.asList(
                    Aggregates.match(filtroUsuario),
                    Aggregates.unwind("$producto"),
                    Aggregates.project(
                            Projections.fields(
                                    Projections.include("fechaDeRenta", "fechaDeDevolucion", "costoRenta", "cantidad"),
                                    Projections.computed("titulo", "$producto.titulo"),
                                    Projections.computed("isbn", "$producto.isbn")
                            )
                    ),
                    Aggregates.sort(Sorts.ascending("fechaDePago"))
            );

            List<Document> documentosHistorial = new ArrayList<>(coleccionRenta.aggregate(pipeline, Document.class).into(new ArrayList<>()));

            List<Object> historialRentas = new ArrayList<>();
            for (Document documento : documentosHistorial) {
                Map<String, Object> renta = new HashMap<>();
                renta.put("isbn", documento.getInteger("isbn"));
                renta.put("titulo", documento.getString("titulo"));
                renta.put("fechaDeRenta", documento.getDate("fechaDeRenta"));
                renta.put("fechaDeDevolucion", documento.getDate("fechaDeDevolucion"));
                renta.put("costoRenta", documento.getDouble("costoRenta"));
                renta.put("cantidad", documento.getInteger("cantidad"));
                historialRentas.add(renta);
            }

            return historialRentas;

        } catch (MongoException e) {
            throw new PersistenciaException("Error al consultar el historial de compras por el usuario: " + e.getMessage());
        }
    }

    @Override
    public List<Object> consultarHistorialRentasPorUsuarioMeses(String nombreUsuario, int año, int mes) throws PersistenciaException {
        try {
            // Establecer la fecha de inicio para el primer día del mes y año especificados
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, año);
            cal.set(Calendar.MONTH, mes - 1); // Calendar.MONTH comienza en 0 para enero
            cal.set(Calendar.DAY_OF_MONTH, 1);
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            java.util.Date fechaInicio = cal.getTime();

            // Establecer la fecha de fin para el último día del mes y año especificados
            cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
            cal.set(Calendar.HOUR_OF_DAY, 23);
            cal.set(Calendar.MINUTE, 59);
            cal.set(Calendar.SECOND, 59);
            cal.set(Calendar.MILLISECOND, 999);
            java.util.Date fechaFin = cal.getTime();

            Bson filtroUsuario = Filters.eq("usuario.nombreUsuario", nombreUsuario);
            Bson filtroFecha = Filters.and(
                    Filters.gte("fechaDeRenta", fechaInicio),
                    Filters.lte("fechaDeRenta", fechaFin)
            );

            List<Bson> pipeline = Arrays.asList(
                    Aggregates.match(filtroUsuario),
                    Aggregates.match(filtroFecha),
                    Aggregates.unwind("$producto"),
                    Aggregates.project(
                            Projections.fields(
                                    Projections.include("fechaDeRenta", "fechaDeDevolucion","costoRenta", "cantidad"),
                                    Projections.computed("titulo", "$producto.titulo"),
                                    Projections.computed("isbn", "$producto.isbn")
                            )
                    ),
                    Aggregates.sort(Sorts.ascending("fechaDeRenta"))
            );

            List<Document> documentosHistorial = new ArrayList<>(coleccionRenta.aggregate(pipeline, Document.class).into(new ArrayList<>()));

            List<Object> historialCompras = new ArrayList<>();
            for (Document documento : documentosHistorial) {
                Map<String, Object> renta = new HashMap<>();
                renta.put("isbn", documento.getInteger("isbn"));
                renta.put("titulo", documento.getString("titulo"));
                renta.put("fechaDeRenta", documento.getDate("fechaDeRenta"));
                renta.put("fechaDeDevolucion", documento.getDate("fechaDeDevolucion")); 
                renta.put("costoTotal", documento.getDouble("costoTotal"));
                renta.put("cantidad", documento.getInteger("cantidad"));
                historialCompras.add(renta);
            }

            return historialCompras;
        } catch (MongoException e) {
            throw new PersistenciaException("Error al consultar el historial de rentas por el usuario: " + e.getMessage());
        }
    }

}
