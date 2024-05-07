
package PagoPorTarjeta;


import DTO.PagoPorTarjetaDTO;
import INegocio.IPagoBO;
import INegocio.IProductoBO;
import IPagoPorTarjeta.IPagoPorTarjeta;
import Negocio.PagoBO;

public class FuncionalidadPagoPorTarjeta implements IPagoPorTarjeta{
    
    IPagoBO comprarProductoBO;

    public FuncionalidadPagoPorTarjeta() {
        comprarProductoBO= new PagoBO();
    }
    
    
    @Override
    public void comprarProductoPorTarjeta(PagoPorTarjetaDTO pagoPorTarjetaDTO) {
        comprarProductoBO.ComprarProductoPorTarjeta(pagoPorTarjetaDTO);
    }
}
