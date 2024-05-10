/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Roberto Verdugo Beltran
 */
public class Renta {

    private ObjectId id;
    private Date fechaRenta;
    private Date fechaDevolucion;
    private int cantidad;
    private double costoRenta;
    private List<Usuario> usuario;
    private List<Producto> producto;
    private List<PagoPorOxxo> pagoPorOxxo;
    private List<PagoPorTarjeta> pagoPorTarjeta;

    public Renta() {
        this.usuario = new ArrayList<>();
        this.producto = new ArrayList<>();
        this.pagoPorOxxo = new ArrayList<>();
        this.pagoPorTarjeta = new ArrayList<>();
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Date getFechaRenta() {
        return fechaRenta;
    }

    public void setFechaRenta(Date fechaRenta) {
        this.fechaRenta = fechaRenta;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getCostoRenta() {
        return costoRenta;
    }

    public void setCostoRenta(double costoRenta) {
        this.costoRenta = costoRenta;
    }

    public List<Usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(List<Usuario> usuario) {
        this.usuario = usuario;
    }

    public List<Producto> getProducto() {
        return producto;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }

    public List<PagoPorOxxo> getPagoPorOxxo() {
        return pagoPorOxxo;
    }

    public void setPagoPorOxxo(List<PagoPorOxxo> pagoPorOxxo) {
        this.pagoPorOxxo = pagoPorOxxo;
    }

    public List<PagoPorTarjeta> getPagoPorTarjeta() {
        return pagoPorTarjeta;
    }

    public void setPagoPorTarjeta(List<PagoPorTarjeta> pagoPorTarjeta) {
        this.pagoPorTarjeta = pagoPorTarjeta;
    }

    @Override
    public String toString() {
        return "Renta{" + "id=" + id + ", fechaRenta=" + fechaRenta + ", fechaDevolucion=" + fechaDevolucion + ", cantidad=" + cantidad + ", costoRenta=" + costoRenta + ", usuario=" + usuario + ", producto=" + producto + ", pagoPorOxxo=" + pagoPorOxxo + ", pagoPorTarjeta=" + pagoPorTarjeta + '}';
    }

}
