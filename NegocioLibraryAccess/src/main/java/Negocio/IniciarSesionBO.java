/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAO.UsuarioDAO;
import DTO.UsuarioDTO;
import Dominio.Usuario;

/**
 *
 * @author INEGI
 */
public class IniciarSesionBO {
 UsuarioDAO usuarioDAO;

    public IniciarSesionBO() {
        usuarioDAO = UsuarioDAO.getInstancia();
    }

   public boolean buscarUsuario(String nombreUsuario, String contraseña) {
        return usuarioDAO.buscarUsuario(nombreUsuario, contraseña);
    }

    public UsuarioDTO UsuarioInicioSesion(String nombreUsuario, String contraseña) {
        Usuario usuario = usuarioDAO.UsuarioInicioSesion(nombreUsuario, contraseña);
        if (usuario != null) {
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setIdUsuario(usuario.getIdUsuario());
            usuarioDTO.setNombreUsuario(usuario.getNombreUsuario());
            usuarioDTO.setContraseña(usuario.getContraseña());
            return usuarioDTO;
        } else {
            return null;
        }
    }
}
