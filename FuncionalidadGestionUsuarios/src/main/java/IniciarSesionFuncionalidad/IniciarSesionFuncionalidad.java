/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IniciarSesionFuncionalidad;

import DTO.UsuarioDTO;
import IFuncionalidadGestionUsuarios.IiniciarSesionFuncionalidad;
import INegocio.IUsuarioBO;
import Negocio.UsuarioBO;


/**
 *
 * @author INEGI
 */
public class IniciarSesionFuncionalidad implements IiniciarSesionFuncionalidad {

    IUsuarioBO iniciarSesionBO;

    public IniciarSesionFuncionalidad() {
        iniciarSesionBO = new UsuarioBO();

    }

    @Override
    public boolean iniciarSesion(String nombreUsuario, String contraseña) {
        return iniciarSesionBO.buscarUsuario(nombreUsuario, contraseña);
    }

    @Override
    public UsuarioDTO obtenerUsuarioDTO(String nombreUsuario, String contraseña) {
            return iniciarSesionBO.UsuarioInicioSesion(nombreUsuario, contraseña);
    }
}
