/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.util.List;

/**
 *
 * @author INEGI
 */
public class Pago {
   private int idPago;
    private Usuario usuario;
    private Producto producto;
    private int cantidad;
    private double costoTotal;
    private String metodoPago;

    public Pago(int idPago, Usuario usuario, Producto producto, int cantidad, double costoTotal, String metodoPago) {
        this.idPago = idPago;
        this.usuario = usuario;
        this.producto = producto;
        this.cantidad = cantidad;
        this.costoTotal = costoTotal;
        this.metodoPago = metodoPago;
    }

    public Pago(Usuario usuario, Producto producto, int cantidad, double costoTotal, String metodoPago) {
        this.usuario = usuario;
        this.producto = producto;
        this.cantidad = cantidad;
        this.costoTotal = costoTotal;
        this.metodoPago = metodoPago;
    }

    public Pago() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
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

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    @Override
    public String toString() {
        return "Pago{" + "idPago=" + idPago + ", usuario=" + usuario + ", producto=" + producto + ", cantidad=" + cantidad + ", costoTotal=" + costoTotal + ", metodoPago=" + metodoPago + '}';
    }
}
