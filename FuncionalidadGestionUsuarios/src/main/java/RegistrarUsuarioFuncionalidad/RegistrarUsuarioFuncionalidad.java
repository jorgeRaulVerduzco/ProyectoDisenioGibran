/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RegistrarUsuarioFuncionalidad;

import DTO.UsuarioDTO;
import IFuncionalidadGestionUsuarios.IRegistrarUsuarioFuncionalidad;
import INegocio.IRegistarUsuarioBO;
import Negocio.RegistrarUsuarioBO;

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
        registrarUsuarioBO.agregarUsuario(usuarioDTO);
    }
}
