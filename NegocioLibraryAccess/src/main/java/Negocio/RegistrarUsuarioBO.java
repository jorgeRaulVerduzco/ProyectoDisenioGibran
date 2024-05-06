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
import INegocio.IRegistarUsuarioBO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author INEGI
 */
public class RegistrarUsuarioBO implements IRegistarUsuarioBO{
 IUsuarioDAO usuarioDAO;
    DTOaEntidadBO dtoaEntidadBO;

    public RegistrarUsuarioBO() {
        usuarioDAO = new UsuarioDAO ();
        dtoaEntidadBO = new DTOaEntidadBO();
    }

 @Override
    public void agregarUsuario(UsuarioDTO usuarioDTO)  {
     try {
         usuarioDAO.agregarUsuario(dtoaEntidadBO.ConvertirUsuarioDTO(usuarioDTO));
     } catch (PersistenciaException ex) {
         Logger.getLogger(RegistrarUsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
     }
    }
}
