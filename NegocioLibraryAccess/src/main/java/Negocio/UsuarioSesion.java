/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DTO.UsuarioDTO;

/**
 *
 * @author INEGI
 */
public class UsuarioSesion {
    private static UsuarioDTO usuarioSesion;
    
    
    public static UsuarioDTO usuarioSesion(){
        return usuarioSesion;
    }
    
     public static void setUsuarioSeleccionado(UsuarioDTO usuario){
         usuarioSesion=usuario;
     }
}
