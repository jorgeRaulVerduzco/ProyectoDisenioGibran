/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package INegocio;

import DTO.ProductoDTO;
import DTO.RentaDTO;
import DTO.RentaPorOxxoDTO;
import DTO.RentaPorTarjetaDTO;
import java.util.List;

/**
 *
 * @author rober
 */
public interface IRentaBO {

    public void rentarProducto(RentaDTO rentaDTO);

    public void rentarProductoPorOxxo(RentaPorOxxoDTO rentaPorOxxoDTO);

    public void rentarProductoPorTarjeta(RentaPorTarjetaDTO rentaPorTarjetaDTO);

    public List<ProductoDTO> consultarPorductosRentadosPorUsuario(String nombreUsuario);

    public List<Object> consultarHistorialRentasPorUsuario(String nombreUsuario);

    public List<Object> consultarHistorialRentasPorUsuarioMeses(String nombreUsuario, int anho, int mes);
}
