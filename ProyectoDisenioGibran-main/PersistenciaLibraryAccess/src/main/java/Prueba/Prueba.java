/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Prueba;

import DAO.PagoDAO;
import DAO.ProductoDAO;
import DAO.ReseñaDAO;
import DAO.UsuarioDAO;
import Dominio.Producto;
import Dominio.Reseña;
import Dominio.Usuario;
import Excepciones.PersistenciaException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JORGE
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws PersistenciaException {
       
PagoDAO pagoDAO = new PagoDAO();
 
        System.out.println(pagoDAO.consultarProductosCompradosPorUsuario("a"));
        
        ReseñaDAO reseñaDAO = new ReseñaDAO();
        
        System.out.println( reseñaDAO.obtenerReseñasDeProducto(456));    
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("a");
        usuario.setContraseña("lol");
        usuarioDAO.agregarUsuario(usuario);
    }
    
}
