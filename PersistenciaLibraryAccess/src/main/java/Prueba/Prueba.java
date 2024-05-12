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
       
ReseñaDAO reseñaDao = new ReseñaDAO();
        System.out.println(reseñaDao.obtenerReseñasDeUsuario("jorgendo43"));
        
        PagoDAO po = new PagoDAO();
//        System.out.println( po.consultarHistorialComprasPorUsuario("Bell"));
        System.out.println(po.consultarHistorialComprasPorUsuarioMeses("Bell", 2024, 3));
        
        ProductoDAO pe = new ProductoDAO();
//        System.out.println(pe.buscarProductosPorIsbn(12));
    }
    
}
