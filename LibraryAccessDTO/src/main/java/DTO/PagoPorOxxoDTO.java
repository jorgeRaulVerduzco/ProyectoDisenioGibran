/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author INEGI
 */
public class PagoPorOxxoDTO extends PagoDTO{
       private String codigoBarrasOxxo;

    

    public PagoPorOxxoDTO(UsuarioDTO usuario, ProductoDTO producto, int cantidad, double costoTotal, String codigoBarrasOxxo) {
        super(usuario, producto, cantidad, costoTotal, "Oxxo");
        this.codigoBarrasOxxo = codigoBarrasOxxo;
    }

    public String getCodigoBarrasOxxo() {
        return codigoBarrasOxxo;
    }

    public void setCodigoBarrasOxxo(String codigoBarrasOxxo) {
        this.codigoBarrasOxxo = codigoBarrasOxxo;
    }

    @Override
    public String toString() {
        return "PagoPorOxxoDTO{" + "codigoBarrasOxxo=" + codigoBarrasOxxo + '}';
    }

    

}
