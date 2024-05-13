/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.ConexionBD;
import Dominio.Producto;
import Dominio.Usuario;
import Excepciones.PersistenciaException;
import IDAO.IUsuarioDAO;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.util.ArrayList;
import java.util.List;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author INEGI
 */
public class UsuarioDAO implements IUsuarioDAO {

    private final MongoCollection<Usuario> coleccionUsuarios;

    public UsuarioDAO() {
        this.coleccionUsuarios = ConexionBD.getDatabase().getCollection("Usuario", Usuario.class);
    }

    @Override
    public void agregarUsuario(Usuario usuario) throws PersistenciaException {
        try {
            if (existeNombreUsuario(usuario.getNombreUsuario())) {
                System.out.println("Advertencia: Ya existe un usuario con ese nombre de usuario: " + usuario.getNombreUsuario());
                return;
            }

            this.coleccionUsuarios.insertOne(usuario);
            ObjectId idGenerado = usuario.getIdUsuario();
            System.out.println(idGenerado);
        } catch (MongoException e) {
            System.err.println("Error al agregar usuario: " + e.getMessage());
        }
    }

    @Override
    public void agregarProductoVendido(String nombreUsuario, Producto productoVendido) throws PersistenciaException {
        try {
            ProductoDAO productoDAO = new ProductoDAO();
            productoDAO.agregarProducto(productoVendido);

            // Luego, actualizamos la lista de productos vendidos del usuario
            Bson filtroNombreUsuario = Filters.eq("nombreUsuario", nombreUsuario);
            Usuario usuario = coleccionUsuarios.find(filtroNombreUsuario).first();
            if (usuario != null) {
                List<Producto> productosVendidos = usuario.getProductosVendidos();
                productosVendidos.add(productoVendido);
                Bson actualizacion = Updates.set("productosVendidos", productosVendidos);
                coleccionUsuarios.updateOne(filtroNombreUsuario, actualizacion);
            } else {
                System.out.println("El usuario con nombre " + nombreUsuario + " no existe.");
            }
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo actualizar la lista de productos vendidos para el usuario: " + nombreUsuario);
        }
    }

    @Override
    public List<Producto> obtenerHistorialProductosVendidos(String nombreUsuario) throws PersistenciaException {
        List<Producto> historialProductosVendidos = new ArrayList<>();
        try {
            Bson filtroNombreUsuario = Filters.eq("nombreUsuario", nombreUsuario);
            Usuario usuario = coleccionUsuarios.find(filtroNombreUsuario).first();
            if (usuario != null) {
                historialProductosVendidos = usuario.getProductosVendidos();
            } else {
                System.out.println("El usuario con nombre " + nombreUsuario + " no existe.");
            }
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo obtener el historial de productos vendidos para el usuario: " + nombreUsuario);
        }
        return historialProductosVendidos;
    }

    private boolean existeNombreUsuario(String nombreUsuario) throws PersistenciaException {
        try {
            Bson filtro = Filters.eq("nombreUsuario", nombreUsuario);
            return coleccionUsuarios.countDocuments(filtro) > 0;
        } catch (MongoException e) {
            throw new PersistenciaException("Error al verificar la existencia del nombre de usuario: " + e.getMessage());
        }
    }

    @Override
    public boolean buscarUsuario(String nombreUsuario, String contraseña) throws PersistenciaException {
        try {
            Bson filtro = Filters.and(Filters.eq("nombreUsuario", nombreUsuario), Filters.eq("contraseña", contraseña));
            return coleccionUsuarios.countDocuments(filtro) > 0;
        } catch (MongoException e) {
            throw new PersistenciaException("Error al buscar usuario: " + e.getMessage());
        }
    }

    @Override
    public Usuario UsuarioInicioSesion(String nombreUsuario, String contraseña) throws PersistenciaException {
        try {
            Bson filtro = Filters.and(Filters.eq("nombreUsuario", nombreUsuario), Filters.eq("contraseña", contraseña));
            return coleccionUsuarios.find(filtro).first();
        } catch (MongoException e) {
            throw new PersistenciaException("Error al iniciar sesión: " + e.getMessage());
        }
    }

    @Override
    public List<Usuario> obtenerTodosLosUsuarios() throws PersistenciaException {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            FindIterable<Usuario> resultados = coleccionUsuarios.find();
            for (Usuario usuario : resultados) {
                usuarios.add(usuario);
            }
        } catch (MongoException e) {
            throw new PersistenciaException("Error al obtener todos los usuarios: " + e.getMessage());
        }
        return usuarios;
    }
}
