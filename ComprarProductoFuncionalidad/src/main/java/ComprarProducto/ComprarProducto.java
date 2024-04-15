/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ComprarProducto;

import DTO.PagoDTO;
import DTO.PagoPorOxxoDTO;
import DTO.PagoPorTarjetaDTO;
import Negocio.ComprarProductoBO;

/**
 *
 * @author INEGI
 */
public class ComprarProducto {

    ComprarProductoBO comprarProductoBO;

    public ComprarProducto() {
        comprarProductoBO = new ComprarProductoBO();
    }

    public void comprarProducto(PagoDTO pagoDTO) {
        comprarProductoBO.ComprarProducto(pagoDTO);
    }

    public void comprarProductoPorOxxo(PagoPorOxxoDTO pagoPorOxxoDTO) {
        comprarProductoBO.ComprarProductoPorOxxo(pagoPorOxxoDTO);
    }

    public void comprarProductoPorTarjeta(PagoPorTarjetaDTO pagoPorTarjetaDTO) {
        comprarProductoBO.ComprarProductoPorTarjeta(pagoPorTarjetaDTO);
    }
}
