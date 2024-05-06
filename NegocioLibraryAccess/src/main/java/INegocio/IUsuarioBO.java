/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package INegocio;

import DTO.UsuarioDTO;
import Excepciones.PersistenciaException;

/**
 *
 * @author INEGI
 */
public interface IUsuarioBO {

    public boolean buscarUsuario(String nombreUsuario, String contraseña) throws PersistenciaException;

    public UsuarioDTO UsuarioInicioSesion(String nombreUsuario, String contraseña) throws PersistenciaException;

    public void agregarUsuario(UsuarioDTO usuarioDTO) throws PersistenciaException;

}
