/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAO.UsuarioDAO;
import DTO.UsuarioDTO;
import Dominio.Usuario;
import Excepciones.PersistenciaException;
import IDAO.IUsuarioDAO;
import INegocio.IRegistarUsuarioBO;

/**
 *
 * @author INEGI
 */
public class RegistrarUsuarioBO implements IRegistarUsuarioBO{
 IUsuarioDAO usuarioDAO;
    DTOaEntidadBO dtoaEntidadBO;

    public RegistrarUsuarioBO() {
        usuarioDAO = new UsuarioDAO ();
        dtoaEntidadBO = new DTOaEntidadBO();
    }

 @Override
    public void agregarUsuario(UsuarioDTO usuarioDTO) throws PersistenciaException {
        usuarioDAO.agregarUsuario(dtoaEntidadBO.ConvertirUsuarioDTO(usuarioDTO));
    }
}
