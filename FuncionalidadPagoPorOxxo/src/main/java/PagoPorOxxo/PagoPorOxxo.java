
package PagoPorOxxo;

import INegocio.IComprarProductoBO;
import DTO.PagoPorOxxoDTO;
import IPagoPorOxxo.IPagoPorOxxo;


public class PagoPorOxxo implements IPagoPorOxxo {
        IComprarProductoBO comprarProductoBO;

     public void comprarProductoPorOxxo(PagoPorOxxoDTO pagoPorOxxoDTO) {
        comprarProductoBO.ComprarProductoPorOxxo(pagoPorOxxoDTO);
    }
}
