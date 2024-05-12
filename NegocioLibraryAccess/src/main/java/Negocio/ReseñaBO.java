/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAO.ReseñaDAO;
import DTO.ReseñaDTO;
import Dominio.Reseña;
import Excepciones.PersistenciaException;
import INegocio.IReseñaBO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author INEGI
 */
public class ReseñaBO implements IReseñaBO {

    ReseñaDAO reseñaDAO;
    DTOaEntidadBO dtoaAentidad;

    public ReseñaBO() {
        reseñaDAO = new ReseñaDAO();
        dtoaAentidad = new DTOaEntidadBO();

    }

    @Override
    public void generarReseña(ReseñaDTO reseñaDTO) {
        Reseña reseña = dtoaAentidad.convertirReseñaDTO(reseñaDTO);
        try {
            reseñaDAO.generarReseña(reseña);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ProductoBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Object> obtenerReseñasDeProducto(int isbn) {
        try {
            return reseñaDAO.obtenerReseñasDeProducto(isbn);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ReseñaBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Object> obtenerReseñasDeUsuario(String nombreUsuario){
        try {
            return reseñaDAO.obtenerReseñasDeUsuario(nombreUsuario);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ReseñaBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
