/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GenerarReseña;

import DTO.ReseñaDTO;
import IGenerarReseña.IGenerarReseña;
import INegocio.IReseñaBO;
import Negocio.ReseñaBO;

/**
 *
 * @author INEGI
 */
public class GenerarReseña implements IGenerarReseña {
    IReseñaBO ReseñaBO;

    public GenerarReseña() {
        this.ReseñaBO = new ReseñaBO();
    }
    
    
    @Override
    public void GenerarReseña(ReseñaDTO reseñaDTO){
        ReseñaBO.generarReseña(reseñaDTO);
    }
    
}
