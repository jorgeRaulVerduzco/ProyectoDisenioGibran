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
 * @author INEGI
 */
public class PagoDTO {
    private ObjectId id;
    private List<UsuarioDTO> usuarioDTO;
    private List<ProductoDTO> productoDTO;
    private int cantidad;
    private double costoTotal;
    private List<PagoPorOxxoDTO> pagoPorOxxoDTO;
    private List<PagoPorTarjetaDTO> pagoPorTarjetaDTO;
    private Date FechaDePago;

    public PagoDTO() {
        this.usuarioDTO = new ArrayList<>();
        this.productoDTO = new ArrayList<>();
        this.pagoPorOxxoDTO = new ArrayList<>();
        this.pagoPorTarjetaDTO = new ArrayList<>();
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
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

    public List<PagoPorOxxoDTO> getPagoPorOxxoDTO() {
        return pagoPorOxxoDTO;
    }

    public void setPagoPorOxxoDTO(List<PagoPorOxxoDTO> pagoPorOxxoDTO) {
        this.pagoPorOxxoDTO = pagoPorOxxoDTO;
    }

    public List<PagoPorTarjetaDTO> getPagoPorTarjetaDTO() {
        return pagoPorTarjetaDTO;
    }

    public void setPagoPorTarjetaDTO(List<PagoPorTarjetaDTO> pagoPorTarjetaDTO) {
        this.pagoPorTarjetaDTO = pagoPorTarjetaDTO;
    }

    public Date getFechaDePago() {
        return FechaDePago;
    }

    public void setFechaDePago(Date FechaDePago) {
        this.FechaDePago = FechaDePago;
    }

    @Override
    public String toString() {
        return "PagoDTO{" + "id=" + id + ", usuarioDTO=" + usuarioDTO + ", productoDTO=" + productoDTO + ", cantidad=" + cantidad + ", costoTotal=" + costoTotal + ", pagoPorOxxoDTO=" + pagoPorOxxoDTO + ", pagoPorTarjetaDTO=" + pagoPorTarjetaDTO + ", FechaDePago=" + FechaDePago + '}';
    }

   

   
}
