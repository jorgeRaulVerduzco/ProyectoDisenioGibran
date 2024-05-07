/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RegistrarUsuarioFuncionalidad;

import DTO.UsuarioDTO;
import IFuncionalidadGestionUsuarios.IRegistrarUsuarioFuncionalidad;
import INegocio.IUsuarioBO;
import Negocio.UsuarioBO;

/**
 *
 * @author INEGI
 */
public class RegistrarUsuarioFuncionalidad implements IRegistrarUsuarioFuncionalidad{
     IUsuarioBO registrarUsuarioBO;

    public RegistrarUsuarioFuncionalidad() {
        registrarUsuarioBO = new UsuarioBO();
    }

     @Override
    public void registrarNuevoUsuario(UsuarioDTO usuarioDTO) {
              registrarUsuarioBO.agregarUsuario(usuarioDTO);
          
    }
}
