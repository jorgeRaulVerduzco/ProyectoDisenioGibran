/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RentarProducto;

import DTO.RentaDTO;
import DTO.RentaPorOxxoDTO;
import DTO.RentaPorTarjetaDTO;
import INegocio.IRentaBO;
import IRentarProducto.IRentarProducto;
import Negocio.RentaBO;

/**
 *
 * @author rober
 */
public class RentarProducto implements IRentarProducto{
    IRentaBO rentarProductoBO;

    public RentarProducto() {
        rentarProductoBO = new RentaBO();
    }

    @Override
    public void rentarProducto(RentaDTO rentaDTO) {
        rentarProductoBO.rentarProducto(rentaDTO);
    }

    @Override
    public void rentarProductoPorOxxo(RentaPorOxxoDTO rentaPorOxxoDTO) {
        rentarProductoBO.rentarProductoPorOxxo(rentaPorOxxoDTO);
    }

    @Override
    public void rentarProductoPorTarjeta(RentaPorTarjetaDTO rentaPorTarjetaDTO) {
        rentarProductoBO.rentarProductoPorTarjeta(rentaPorTarjetaDTO);
    }
    
}
