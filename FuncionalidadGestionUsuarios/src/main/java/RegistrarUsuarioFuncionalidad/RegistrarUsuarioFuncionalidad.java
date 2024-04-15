/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RegistrarUsuarioFuncionalidad;

import DTO.UsuarioDTO;
import Negocio.RegistrarUsuarioBO;

/**
 *
 * @author INEGI
 */
public class RegistrarUsuarioFuncionalidad {
      RegistrarUsuarioBO registrarUsuarioBO;

    public RegistrarUsuarioFuncionalidad() {
        registrarUsuarioBO = new RegistrarUsuarioBO();
    }

    public void registrarNuevoUsuario(UsuarioDTO usuarioDTO) {
        registrarUsuarioBO.agregarUsuario(usuarioDTO);
    }
}
