/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package INegocio;

import DTO.UsuarioDTO;

/**
 *
 * @author INEGI
 */
public interface IUsuarioBO {
    public void agregarUsuario(UsuarioDTO usuarioDTO);
     public boolean buscarUsuario(String nombreUsuario, String contraseña);
       public UsuarioDTO UsuarioInicioSesion(String nombreUsuario, String contraseña);
}