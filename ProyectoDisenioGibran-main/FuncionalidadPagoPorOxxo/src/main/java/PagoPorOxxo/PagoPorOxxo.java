
package PagoPorOxxo;

import DTO.PagoPorOxxoDTO;
import IPagoPorOxxo.IPagoPorOxxo;
import Negocio.PagoBO;


public class PagoPorOxxo implements IPagoPorOxxo {
        PagoBO comprarProductoBO;

    public PagoPorOxxo() {
    }
//prueba
        @Override
     public void comprarProductoPorOxxo(PagoPorOxxoDTO pagoPorOxxoDTO) {
        comprarProductoBO.ComprarProductoPorOxxo(pagoPorOxxoDTO);
    }
}
