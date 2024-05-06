/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IniciarSesionFuncionalidad;

import DTO.UsuarioDTO;
import Excepciones.PersistenciaException;
import IFuncionalidadGestionUsuarios.IiniciarSesionFuncionalidad;
import INegocio.IiniciarSesionBO;
import Negocio.IniciarSesionBO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author INEGI
 */
public class IniciarSesionFuncionalidad implements IiniciarSesionFuncionalidad {

    IiniciarSesionBO iniciarSesionBO;

    public IniciarSesionFuncionalidad() {
        iniciarSesionBO = new IniciarSesionBO();

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
