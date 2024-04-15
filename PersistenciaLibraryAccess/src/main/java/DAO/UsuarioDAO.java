/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Dominio.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author INEGI
 */
public class UsuarioDAO {
private static UsuarioDAO instancia;
    private List<Usuario> listaUsuarios;
    private int proximoId;

    private UsuarioDAO() {
        this.listaUsuarios = new ArrayList<>();
        this.proximoId = 1;
    }

    public static UsuarioDAO getInstancia() {
        if (instancia == null) {
            instancia = new UsuarioDAO();
        }
        return instancia;
    }

    public void agregarUsuario(Usuario usuario) {
        usuario.setIdUsuario(proximoId);
        listaUsuarios.add(usuario);
        proximoId++;
    }

    public boolean buscarUsuario(String nombreUsuario, String contraseña) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombreUsuario().trim().equalsIgnoreCase(nombreUsuario.trim()) && usuario.getContraseña().equals(contraseña)) {
                return true;
            }
        }
        return false;
    }

    public Usuario UsuarioInicioSesion(String nombreUsuario, String contraseña) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombreUsuario().equalsIgnoreCase(nombreUsuario) && usuario.getContraseña().equalsIgnoreCase(contraseña)) {
                return usuario;
            }
        }
        return null;
    }

    public List<Usuario> obtenerTodosLosUsuarios() {
        return listaUsuarios;
    }
}
