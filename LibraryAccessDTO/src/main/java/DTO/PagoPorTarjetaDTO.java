/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author INEGI
 */
public class PagoPorTarjetaDTO extends PagoDTO {
    private String tipoTarjeta;
    private String numeroTarjeta;
    private Date fechaExpiracion;
    private String codigoSeguridad;

    public PagoPorTarjetaDTO() {
    }

    public PagoPorTarjetaDTO(String tipoTarjeta, String numeroTarjeta, Date fechaExpiracion, String codigoSeguridad) {
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
        return "PagoPorTarjetaDTO{" + "tipoTarjeta=" + tipoTarjeta + ", numeroTarjeta=" + numeroTarjeta + ", fechaExpiracion=" + fechaExpiracion + ", codigoSeguridad=" + codigoSeguridad + '}';
    }



}
