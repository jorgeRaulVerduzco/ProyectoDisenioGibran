
package PagoPorTarjeta;


import DTO.PagoPorTarjetaDTO;
import INegocio.IComprarProductoBO;
import IPagoPorTarjeta.IPagoPorTarjeta;

public class FuncionalidadPagoPorTarjeta implements IPagoPorTarjeta{
    
    IComprarProductoBO comprarProductoBO;
    
    @Override
    public void comprarProductoPorTarjeta(PagoPorTarjetaDTO pagoPorTarjetaDTO) {
        comprarProductoBO.ComprarProductoPorTarjeta(pagoPorTarjetaDTO);
    }
}
