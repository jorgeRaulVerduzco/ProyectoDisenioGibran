/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.sql.Date;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

/**
 *
 * @author INEGI
 */
public class PagoPorTarjeta {

    private ObjectId id;
    private String tipoTarjeta;
    private String numeroTarjeta;
    private Date fechaExpiracion;
    private String codigoSeguridad;

    public PagoPorTarjeta() {

    }

    public PagoPorTarjeta(ObjectId id, String tipoTarjeta, String numeroTarjeta, Date fechaExpiracion, String codigoSeguridad) {
        this.tipoTarjeta = tipoTarjeta;
        this.numeroTarjeta = numeroTarjeta;
        this.fechaExpiracion = fechaExpiracion;
        this.codigoSeguridad = codigoSeguridad;
    }

    public PagoPorTarjeta(ObjectId id) {
        this.id = id;
    }

    public PagoPorTarjeta(String tipoTarjeta, String numeroTarjeta, Date fechaExpiracion, String codigoSeguridad) {
        this.tipoTarjeta = tipoTarjeta;
        this.numeroTarjeta = numeroTarjeta;
        this.fechaExpiracion = fechaExpiracion;
        this.codigoSeguridad = codigoSeguridad;
    }

    public ObjectId getIdPagoPorTarjeta() {
        return id;
    }

    public void setIdPagoPorTarjeta(ObjectId id) {
        this.id = id;
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
        return "PagoPorTarjeta{" + "idPagoPorTarjeta=" + id + ", tipoTarjeta=" + tipoTarjeta + ", numeroTarjeta=" + numeroTarjeta + ", fechaExpiracion=" + fechaExpiracion + ", codigoSeguridad=" + codigoSeguridad + '}';
    }

}
