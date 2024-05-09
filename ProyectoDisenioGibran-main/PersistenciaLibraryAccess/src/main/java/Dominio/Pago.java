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
 * @author INEGI
 */
public class Pago {

    private ObjectId id;
    private List<Usuario> usuario;
    private List<Producto> producto;
    private int cantidad;
    private double costoTotal;
    private List<PagoPorOxxo> pagoPorOxxo;
    private List<PagoPorTarjeta> pagoPorTarjeta;
    private Date FechaDePago;

    public Pago() {
        this.usuario = new ArrayList<>();
        this.producto = new ArrayList<>();
        this.pagoPorOxxo = new ArrayList<>();
        this.pagoPorTarjeta = new ArrayList<>();
    }

    public Pago(ObjectId id) {
        this.id = id;
    }

    public Date getFechaDePago() {
        return FechaDePago;
    }

    public void setFechaDePago(Date FechaDePago) {
        this.FechaDePago = FechaDePago;
    }

    public ObjectId getIdPago() {
        return id;
    }

    public void setIdPago(ObjectId id) {
        this.id = id;
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
        return "Pago{" + "idPago=" + id + ", usuario=" + usuario + ", producto=" + producto + ", cantidad=" + cantidad + ", costoTotal=" + costoTotal + ", pagoPorOxxo=" + pagoPorOxxo + ", pagoPorTarjeta=" + pagoPorTarjeta + ", FechaDePago=" + FechaDePago + '}';
    }

}
