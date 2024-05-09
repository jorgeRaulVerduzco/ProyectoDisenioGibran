/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Prueba;

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
    public static void main(String[] args) {
 try {
            Usuario usuario = new Usuario();
            usuario.setNombreUsuario("loco");
            usuario.setContraseña("loco");
            UsuarioDAO dao= new UsuarioDAO();
            dao.agregarUsuario(usuario);
            Producto libroRapunzel = new Producto(45878786, "Rapunzel", "Joaquin", "libro", "Primera", 300, "aventura", 10);
            ProductoDAO productoDAO = new ProductoDAO();
            productoDAO.agregarProducto(libroRapunzel);
            Reseña reseña = new Reseña();
            reseña.setProducto(libroRapunzel);
            reseña.setRating(4);
            reseña.setReseña("es lo mejor");
            reseña.setUsuario(usuario);
            ReseñaDAO daos = new ReseñaDAO();
            daos.generarReseña(reseña);
        } catch (PersistenciaException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
