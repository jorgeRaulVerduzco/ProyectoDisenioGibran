/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAO.UsuarioDAO;
import DTO.UsuarioDTO;
import Dominio.Usuario;

/**
 *
 * @author INEGI
 */
public class RegistrarUsuarioBO {
 UsuarioDAO usuarioDAO;
    DTOaEntidadBO dtoaEntidadBO;

    public RegistrarUsuarioBO() {
        usuarioDAO = UsuarioDAO.getInstancia();
        dtoaEntidadBO = new DTOaEntidadBO();
    }

    public void agregarUsuario(UsuarioDTO usuarioDTO) {
        usuarioDAO.agregarUsuario(dtoaEntidadBO.ConvertirUsuarioDTO(usuarioDTO));
    }
}
