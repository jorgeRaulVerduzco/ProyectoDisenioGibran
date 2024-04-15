/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author INEGI
 */
public class PagoPorOxxo extends Pago {
       private String codigoBarrasOxxo;

    public PagoPorOxxo(Usuario usuario, Producto producto, int cantidad, double costoTotal, String codigoBarrasOxxo) {
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
        return "PagoPorOxxo{" +
                "codigoBarrasOxxo='" + codigoBarrasOxxo + '\'' +
                ", idPago=" + getIdPago() +
                ", usuario=" + getUsuario() +
                ", producto=" + getProducto() +
                ", cantidad=" + getCantidad() +
                ", costoTotal=" + getCostoTotal() +
                ", metodoPago='" + getMetodoPago() + '\'' +
                '}';
    }

}
