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
        comprarProductoBO.ComprarProducto(pagoDTO);
    }

    @Override
    public void comprarProductoPorOxxo(PagoPorOxxoDTO pagoPorOxxoDTO) {
        comprarProductoBO.ComprarProductoPorOxxo(pagoPorOxxoDTO);
    }

    @Override
    public void comprarProductoPorTarjeta(PagoPorTarjetaDTO pagoPorTarjetaDTO) {
        comprarProductoBO.ComprarProductoPorTarjeta(pagoPorTarjetaDTO);
    }
}
