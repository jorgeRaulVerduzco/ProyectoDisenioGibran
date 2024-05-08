/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package INegocio;

import DTO.PagoDTO;
import DTO.PagoPorOxxoDTO;
import DTO.PagoPorTarjetaDTO;
import java.util.List;

/**
 *
 * @author INEGI
 */
public interface IPagoBO {
     public void ComprarProducto(PagoDTO pagoDTO);
      public void ComprarProductoPorOxxo(PagoPorOxxoDTO pagoPorOxxoDTO);
        public void ComprarProductoPorTarjeta(PagoPorTarjetaDTO pagoPorTarjetaDTO);
          public List<Object> consultarProductosCompradosPorUsuario(String nombreUsuario);
}
