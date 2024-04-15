/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;


/**
 *
 * @author INEGI
 */
public class PagoPorTarjeta extends Pago{
     private String tipoTarjeta;
    private String numeroTarjeta;
    private String fechaExpiracion;
    private String codigoSeguridad;

    public PagoPorTarjeta(Usuario usuario, Producto producto, int cantidad, double costoTotal, String tipoTarjeta, String numeroTarjeta, String fechaExpiracion, String codigoSeguridad) {
        super(usuario, producto, cantidad, costoTotal, "Tarjeta");
        this.tipoTarjeta = tipoTarjeta;
        this.numeroTarjeta = numeroTarjeta;
        this.fechaExpiracion = fechaExpiracion;
        this.codigoSeguridad = codigoSeguridad;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public String getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public void setCodigoSeguridad(String codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }

    @Override
    public String toString() {
        return "PagoPorTarjeta{" +
                "tipoTarjeta='" + tipoTarjeta + '\'' +
                ", numeroTarjeta='" + numeroTarjeta + '\'' +
                ", fechaExpiracion='" + fechaExpiracion + '\'' +
                ", codigoSeguridad='" + codigoSeguridad + '\'' +
                ", idPago=" + getIdPago() +
                ", usuario=" + getUsuario() +
                ", producto=" + getProducto() +
                ", cantidad=" + getCantidad() +
                ", costoTotal=" + getCostoTotal() +
                ", metodoPago='" + getMetodoPago() + '\'' +
                '}';
    }
}
