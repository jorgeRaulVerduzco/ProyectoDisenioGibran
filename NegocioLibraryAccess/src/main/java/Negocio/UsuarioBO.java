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
import INegocio.IUsuarioBO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author INEGI
 */
public class UsuarioBO implements IUsuarioBO{
 IUsuarioDAO usuarioDAO;
    DTOaEntidadBO dtoaEntidadBO;

    public UsuarioBO() {
        usuarioDAO = new UsuarioDAO ();
        dtoaEntidadBO = new DTOaEntidadBO();
    }

 @Override
    public void agregarUsuario(UsuarioDTO usuarioDTO)  {
     try {
         usuarioDAO.agregarUsuario(dtoaEntidadBO.ConvertirUsuarioDTO(usuarioDTO));
     } catch (PersistenciaException ex) {
         Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
     }
    }
   @Override
   public boolean buscarUsuario(String nombreUsuario, String contraseña) {
     try {
         return usuarioDAO.buscarUsuario(nombreUsuario, contraseña);
     } catch (PersistenciaException ex) {
         Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
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
         Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
     }
     return null;
    }

    
    
}