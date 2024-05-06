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
import java.util.logging.Level;
import java.util.logging.Logger;

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
   public boolean buscarUsuario(String nombreUsuario, String contraseña) {
     try {
         return usuarioDAO.buscarUsuario(nombreUsuario, contraseña);
     } catch (PersistenciaException ex) {
         Logger.getLogger(IniciarSesionBO.class.getName()).log(Level.SEVERE, null, ex);
     }
     return false;
    }

 @Override
    public UsuarioDTO UsuarioInicioSesion(String nombreUsuario, String contraseña) {
     try {
         Usuario usuario = usuarioDAO.UsuarioInicioSesion(nombreUsuario, contraseña);
         if (usuario != null) {
             UsuarioDTO usuarioDTO = new UsuarioDTO();
             usuarioDTO.setNombreUsuario(usuario.getNombreUsuario());
             usuarioDTO.setContraseña(usuario.getContraseña());
             return usuarioDTO;
         } else {
             return null;
         }
     } catch (PersistenciaException ex) {
         Logger.getLogger(IniciarSesionBO.class.getName()).log(Level.SEVERE, null, ex);
     }
     
     return null;
    }
}
