/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.ConexionBD;
import Dominio.Producto;
import Excepciones.PersistenciaException;
import IDAO.IProductoDAO;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.List;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author INEGI
 */
public class ProductoDAO implements IProductoDAO {

    private final MongoCollection<Producto> coleccionProductos;

    public ProductoDAO() {
        this.coleccionProductos = ConexionBD.getDatabase().getCollection("Producto", Producto.class);

    }

    @Override
    public void agregarProducto(Producto producto) throws PersistenciaException {
        try {
            Bson filtroISBN = Filters.eq("isbn", producto.getIsbn());
            if (coleccionProductos.countDocuments(filtroISBN) > 0) {
                System.out.println("ya esta ese producto");
                return;
            }

            this.coleccionProductos.insertOne(producto);

        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo insertar al producto: " + producto.getIsbn());
        }

    }

    @Override
    public List<Producto> buscarProductosPorNombre(String nombre) throws PersistenciaException {
        List<Producto> productos = new ArrayList<>();
        try {
            Bson filtro = Filters.regex("titulo", nombre, "i");
            FindIterable<Producto> resultados = coleccionProductos.find(filtro);
            for (Producto producto : resultados) {
                productos.add(producto);
            }
        } catch (MongoException e) {
            throw new PersistenciaException("Error al buscar productos por nombre: " + e.getMessage());
        }
        return productos;
    }
    
    public List<Producto> buscarProductosPorIsbn(int isbn) throws PersistenciaException {
        List<Producto> productos = new ArrayList<>();
        try {
            Bson filtro = Filters.eq("isbn", isbn);
            FindIterable<Producto> resultados = coleccionProductos.find(filtro);
            for (Producto producto : resultados) {
                productos.add(producto);
            }
        } catch (MongoException e) {
            throw new PersistenciaException("Error al buscar productos por isbn: " + e.getMessage());
        }
        return productos;
    }

    @Override
    public List<Producto> buscarProductosPorVendedor(String vendedor) throws PersistenciaException {
        List<Producto> productos = new ArrayList<>();
        try {
            Bson filtro = Filters.eq("editorial", vendedor);
            FindIterable<Producto> resultados = coleccionProductos.find(filtro);
            for (Producto producto : resultados) {
                productos.add(producto);
            }
        } catch (MongoException e) {
            throw new PersistenciaException("Error al buscar productos por editorial: " + e.getMessage());
        }
        return productos;
    }

    @Override
    public List<Producto> obtenerTodosProductos() throws PersistenciaException {
        List<Producto> productos = new ArrayList<>();
        try {
            FindIterable<Producto> resultados = coleccionProductos.find();
            for (Producto producto : resultados) {
                productos.add(producto);
            }
        } catch (MongoException e) {
            throw new PersistenciaException("Error al obtener todos los productos: " + e.getMessage());
        }
        return productos;
    }
    
    @Override
    public List<Producto> buscarProductosPorAutor(String autor) throws PersistenciaException {
    List<Producto> productos = new ArrayList<>();
    try {
        Bson filtro = Filters.eq("autor", autor);
        FindIterable<Producto> resultados = coleccionProductos.find(filtro);
        for (Producto producto : resultados) {
            productos.add(producto);
        }
    } catch (MongoException e) {
        throw new PersistenciaException("Error al buscar productos por autor: " + e.getMessage());
    }
    return productos;
}

    @Override
    public List<Producto> buscarProductosPorCategoria(String categoria) throws PersistenciaException {
    List<Producto> productos = new ArrayList<>();
    try {
        Bson filtro = Filters.eq("categoria", categoria);
        FindIterable<Producto> resultados = coleccionProductos.find(filtro);
        for (Producto producto : resultados) {
            productos.add(producto);
        }
    } catch (MongoException e) {
        throw new PersistenciaException("Error al buscar productos por categoría: " + e.getMessage());
    }
    return productos;
}

}
