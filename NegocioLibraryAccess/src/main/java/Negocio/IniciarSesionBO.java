/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAO.UsuarioDAO;
import DTO.UsuarioDTO;
import Dominio.Usuario;
import Excepciones.PersistenciaException;
import IDAO.IUsuarioDAO;
import INegocio.IiniciarSesionBO;

/**
 *
 * @author INEGI
 */
public class IniciarSesionBO implements IiniciarSesionBO {
 IUsuarioDAO usuarioDAO;

    public IniciarSesionBO() {
        usuarioDAO = new  UsuarioDAO();
    }

 @Override
   public boolean buscarUsuario(String nombreUsuario, String contraseña) throws PersistenciaException{
        return usuarioDAO.buscarUsuario(nombreUsuario, contraseña);
    }

 @Override
    public UsuarioDTO UsuarioInicioSesion(String nombreUsuario, String contraseña) throws PersistenciaException {
        Usuario usuario = usuarioDAO.UsuarioInicioSesion(nombreUsuario, contraseña);
        if (usuario != null) {
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setNombreUsuario(usuario.getNombreUsuario());
            usuarioDTO.setContraseña(usuario.getContraseña());
            return usuarioDTO;
        } else {
            return null;
        }
    }
}
