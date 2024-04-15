/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IniciarSesionFuncionalidad;

import DTO.UsuarioDTO;
import Negocio.IniciarSesionBO;

/**
 *
 * @author INEGI
 */
public class IniciarSesionFuncionalidad {

    IniciarSesionBO iniciarSesionBO;

    public IniciarSesionFuncionalidad() {
        iniciarSesionBO = new IniciarSesionBO();

    }

    public boolean iniciarSesion(String nombreUsuario, String contraseña) {
        return iniciarSesionBO.buscarUsuario(nombreUsuario, contraseña);
    }

    public UsuarioDTO obtenerUsuarioDTO(String nombreUsuario, String contraseña) {
        return iniciarSesionBO.UsuarioInicioSesion(nombreUsuario, contraseña);
    }
}
