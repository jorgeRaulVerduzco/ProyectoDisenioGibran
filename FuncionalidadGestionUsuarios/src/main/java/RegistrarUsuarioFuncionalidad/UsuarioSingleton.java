/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RegistrarUsuarioFuncionalidad;

import DTO.UsuarioDTO;

/**
 *
 * @author INEGI
 */
public class UsuarioSingleton {
     private static UsuarioSingleton instancia;
    private UsuarioDTO usuarioDTO;

    private UsuarioSingleton() {
        usuarioDTO = new UsuarioDTO();
    }

    public static UsuarioSingleton getInstancia() {
        if (instancia == null) {
            instancia = new UsuarioSingleton();
        }
        return instancia;
    }

    public UsuarioDTO getUsuarioDTO() {
        return usuarioDTO;
    }
}
