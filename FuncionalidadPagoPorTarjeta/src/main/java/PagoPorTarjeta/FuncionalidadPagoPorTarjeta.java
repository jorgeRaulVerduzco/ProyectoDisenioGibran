
package PagoPorTarjeta;


import DTO.PagoPorTarjetaDTO;
import INegocio.IComprarProductoBO;
import Negocio.ComprarProductoBO;

public class FuncionalidadPagoPorTarjeta {
    
    IComprarProductoBO comprarProductoBO;
    
public void comprarProductoPorTarjeta(PagoPorTarjetaDTO pagoPorTarjetaDTO) {
        comprarProductoBO.ComprarProductoPorTarjeta(pagoPorTarjetaDTO);
    }
}
