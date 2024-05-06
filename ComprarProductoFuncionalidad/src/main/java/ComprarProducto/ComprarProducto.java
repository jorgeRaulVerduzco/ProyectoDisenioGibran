/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ComprarProducto;

import DTO.PagoDTO;
import DTO.PagoPorOxxoDTO;
import DTO.PagoPorTarjetaDTO;
import Excepciones.PersistenciaException;
import IComprarProducto.IComprarProducto;
import INegocio.IComprarProductoBO;
import Negocio.ComprarProductoBO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author INEGI
 */
public class ComprarProducto implements IComprarProducto {

    IComprarProductoBO comprarProductoBO;

    public ComprarProducto() {
        comprarProductoBO = new ComprarProductoBO();
    }

    @Override
    public void comprarProducto(PagoDTO pagoDTO) {
        try {
            comprarProductoBO.ComprarProducto(pagoDTO);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ComprarProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void comprarProductoPorOxxo(PagoPorOxxoDTO pagoPorOxxoDTO) {
        try {
            comprarProductoBO.ComprarProductoPorOxxo(pagoPorOxxoDTO);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ComprarProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void comprarProductoPorTarjeta(PagoPorTarjetaDTO pagoPorTarjetaDTO) {
        try {
            comprarProductoBO.ComprarProductoPorTarjeta(pagoPorTarjetaDTO);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ComprarProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
