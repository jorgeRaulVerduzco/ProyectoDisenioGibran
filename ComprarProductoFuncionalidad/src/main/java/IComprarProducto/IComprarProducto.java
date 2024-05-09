/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IComprarProducto;

import DTO.PagoDTO;
import DTO.PagoPorOxxoDTO;
import DTO.PagoPorTarjetaDTO;

/**
 *
 * @author INEGI
 */
public interface IComprarProducto {
    public void comprarProducto(PagoDTO pagoDTO);
    public void comprarProductoPorOxxo(PagoPorOxxoDTO pagoPorOxxoDTO);
    public void comprarProductoPorTarjeta(PagoPorTarjetaDTO pagoPorTarjetaDTO);
}
