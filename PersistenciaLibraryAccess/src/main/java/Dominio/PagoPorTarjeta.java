/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.sql.Date;
import org.bson.types.ObjectId;


/**
 *
 * @author INEGI
 */
public class PagoPorTarjeta {
    private ObjectId idPagoPorTarjeta;
     private String tipoTarjeta;
    private String numeroTarjeta;
    private Date fechaExpiracion;
    private String codigoSeguridad;

    public PagoPorTarjeta() {
    }

    public PagoPorTarjeta(ObjectId idPagoPorTarjeta, String tipoTarjeta, String numeroTarjeta, Date fechaExpiracion, String codigoSeguridad) {
        this.idPagoPorTarjeta = idPagoPorTarjeta;
        this.tipoTarjeta = tipoTarjeta;
        this.numeroTarjeta = numeroTarjeta;
        this.fechaExpiracion = fechaExpiracion;
        this.codigoSeguridad = codigoSeguridad;
    }

    public ObjectId getidPagoPorTarjeta() {
        return idPagoPorTarjeta;
    }

    public void setIdPago(ObjectId idPagoPorTarjeta) {
        this.idPagoPorTarjeta = idPagoPorTarjeta;
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

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
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
        return "PagoPorTarjeta{" + "ididPagoPorTarjeta=" + idPagoPorTarjeta + ", tipoTarjeta=" + tipoTarjeta + ", numeroTarjeta=" + numeroTarjeta + ", fechaExpiracion=" + fechaExpiracion + ", codigoSeguridad=" + codigoSeguridad + '}';
    }

  
}
