/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package INegocio;

import DTO.PagoDTO;
import DTO.PagoPorOxxoDTO;
import DTO.PagoPorTarjetaDTO;
import Excepciones.PersistenciaException;

/**
 *
 * @author INEGI
 */
public interface IComprarProductoBO {
        public void ComprarProducto(PagoDTO pagoDTO)  throws PersistenciaException;
        public void ComprarProductoPorOxxo(PagoPorOxxoDTO pagoPorOxxoDTO)  throws PersistenciaException;
          public void ComprarProductoPorTarjeta(PagoPorTarjetaDTO pagoPorTarjetaDTO)  throws PersistenciaException;
}
