/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IDAO;

import Dominio.Producto;
import Dominio.Usuario;
import Excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author INEGI
 */
public interface IUsuarioDAO {

    public void agregarUsuario(Usuario usuario) throws PersistenciaException;

    public boolean buscarUsuario(String nombreUsuario, String contraseña) throws PersistenciaException;

    public Usuario UsuarioInicioSesion(String nombreUsuario, String contraseña) throws PersistenciaException;

    public List<Usuario> obtenerTodosLosUsuarios() throws PersistenciaException;

    public List<Producto> obtenerHistorialProductosVendidos(String nombreUsuario) throws PersistenciaException;

    public void agregarProductoVendido(String nombreUsuario, Producto productoVendido) throws PersistenciaException;
}
