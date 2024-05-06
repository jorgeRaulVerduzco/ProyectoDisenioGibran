/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RegistrarUsuarioFuncionalidad;

import DTO.UsuarioDTO;
import Excepciones.PersistenciaException;
import IFuncionalidadGestionUsuarios.IRegistrarUsuarioFuncionalidad;
import INegocio.IRegistarUsuarioBO;
import Negocio.RegistrarUsuarioBO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author INEGI
 */
public class RegistrarUsuarioFuncionalidad implements IRegistrarUsuarioFuncionalidad{
      IRegistarUsuarioBO registrarUsuarioBO;

    public RegistrarUsuarioFuncionalidad() {
        registrarUsuarioBO = new RegistrarUsuarioBO();
    }

    public void registrarNuevoUsuario(UsuarioDTO usuarioDTO) {
          try {
              registrarUsuarioBO.agregarUsuario(usuarioDTO);
          } catch (PersistenciaException ex) {
              Logger.getLogger(RegistrarUsuarioFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
}
