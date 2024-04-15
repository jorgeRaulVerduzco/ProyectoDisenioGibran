/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author INEGI
 */
public class PagoDTO {
      private int idPago;
    private UsuarioDTO usuario;
    private ProductoDTO producto;
    private int cantidad;
    private double costoTotal;
    private String metodoPago;

    public PagoDTO(int idPago, UsuarioDTO usuario, ProductoDTO producto, int cantidad, double costoTotal, String metodoPago) {
        this.idPago = idPago;
        this.usuario = usuario;
        this.producto = producto;
        this.cantidad = cantidad;
        this.costoTotal = costoTotal;
        this.metodoPago = metodoPago;
    }

    public PagoDTO(UsuarioDTO usuario, ProductoDTO producto, int cantidad, double costoTotal, String metodoPago) {
        this.usuario = usuario;
        this.producto = producto;
        this.cantidad = cantidad;
        this.costoTotal = costoTotal;
        this.metodoPago = metodoPago;
    }

    public PagoDTO() {
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    @Override
    public String toString() {
        return "PagoDTO{" +
                "idPago=" + idPago +
                ", usuario=" + usuario +
                ", producto=" + producto +
                ", cantidad=" + cantidad +
                ", costoTotal=" + costoTotal +
                ", metodoPago='" + metodoPago + '\'' +
                '}';
    }
}
