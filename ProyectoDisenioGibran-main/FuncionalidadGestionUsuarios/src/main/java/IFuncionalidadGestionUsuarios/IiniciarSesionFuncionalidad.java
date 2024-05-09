/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IFuncionalidadGestionUsuarios;

import DTO.UsuarioDTO;

/**
 *
 * @author INEGI
 */
public interface IiniciarSesionFuncionalidad {
    public boolean iniciarSesion(String nombreUsuario, String contraseña);
    public UsuarioDTO obtenerUsuarioDTO(String nombreUsuario, String contraseña);
}
