/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author rober
 */
public class RentaDTO {

    private ObjectId id;
    private Date fechaRenta;
    private Date fechaDevolucion;
    private int cantidad;
    private double costoRenta;
    private List<UsuarioDTO> usuarioDTO;
    private List<ProductoDTO> productoDTO;
    private List<RentaPorOxxoDTO> rentaPorOxxoDTO;
    private List<RentaPorTarjetaDTO> rentaPorTarjetaDTO;

    public RentaDTO() {
        this.usuarioDTO = new ArrayList<>();
        this.productoDTO = new ArrayList<>();
        this.rentaPorOxxoDTO = new ArrayList<>();
        this.rentaPorTarjetaDTO = new ArrayList<>();
    }

    public RentaDTO(ObjectId id, Date fechaRenta, Date fechaDevolucion, int cantidad, double costoRenta) {
        this.id = id;
        this.fechaRenta = fechaRenta;
        this.fechaDevolucion = fechaDevolucion;
        this.cantidad = cantidad;
        this.costoRenta = costoRenta;
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

    public List<UsuarioDTO> getUsuarioDTO() {
        return usuarioDTO;
    }

    public void setUsuarioDTO(List<UsuarioDTO> usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
    }

    public List<ProductoDTO> getProductoDTO() {
        return productoDTO;
    }

    public void setProductoDTO(List<ProductoDTO> productoDTO) {
        this.productoDTO = productoDTO;
    }

    public List<RentaPorOxxoDTO> getRentaPorOxxoDTO() {
        return rentaPorOxxoDTO;
    }

    public void setRentaPorOxxoDTO(List<RentaPorOxxoDTO> rentaPorOxxoDTO) {
        this.rentaPorOxxoDTO = rentaPorOxxoDTO;
    }

    public List<RentaPorTarjetaDTO> getRentaPorTarjetaDTO() {
        return rentaPorTarjetaDTO;
    }

    public void setRentaPorTarjetaDTO(List<RentaPorTarjetaDTO> rentaPorTarjetaDTO) {
        this.rentaPorTarjetaDTO = rentaPorTarjetaDTO;
    }

    @Override
    public String toString() {
        return "RentaDTO{" + "id=" + id + ", fechaRenta=" + fechaRenta + ", fechaDevolucion=" + fechaDevolucion + ", cantidad=" + cantidad + ", costoRenta=" + costoRenta + ", usuarioDTO=" + usuarioDTO + ", productoDTO=" + productoDTO + ", rentaPorOxxoDTO=" + rentaPorOxxoDTO + ", rentaPorTarjetaDTO=" + rentaPorTarjetaDTO + '}';
    }

}
