/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.ConexionBD;
import Dominio.Usuario;
import Excepciones.PersistenciaException;
import IDAO.IUsuarioDAO;
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
public class UsuarioDAO implements IUsuarioDAO {

    private final MongoCollection<Usuario> coleccionUsuarios;

    public UsuarioDAO() {
        this.coleccionUsuarios = ConexionBD.getDatabase().getCollection("Usuario", Usuario.class);
    }

    @Override
    public void agregarUsuario(Usuario usuario) throws PersistenciaException {
        try {
            this.coleccionUsuarios.insertOne(usuario);
        } catch (MongoException e) {
            throw new PersistenciaException("No se pudo insertar al usuario: " + usuario.getNombreUsuario());
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
