/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IRentarProducto;

import DTO.RentaDTO;
import DTO.RentaPorOxxoDTO;
import DTO.RentaPorTarjetaDTO;

/**
 *
 * @author rober
 */
public interface IRentarProducto {
    public void rentarProducto(RentaDTO rentaDTO);
    public void rentarProductoPorOxxo(RentaPorOxxoDTO rentaPorOxxoDTO);
    public void rentarProductoPorTarjeta(RentaPorTarjetaDTO rentaPorTarjetaDTO);
}
