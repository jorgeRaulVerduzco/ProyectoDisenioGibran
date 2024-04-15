/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.time.LocalDateTime;

/**
 *
 * @author INEGI
 */
public class Ticket {
     private int idTicket;
    private String codigoBarras;
    private Pago pago;
    private LocalDateTime fechaPago;

    public Ticket() {
    }

    public Ticket(String codigoBarras, Pago pago, LocalDateTime fechaPago) {
        this.codigoBarras = codigoBarras;
        this.pago = pago;
        this.fechaPago = fechaPago;
    }

    public Ticket(int idTicket, String codigoBarras, Pago pago, LocalDateTime fechaPago) {
        this.idTicket = idTicket;
        this.codigoBarras = codigoBarras;
        this.pago = pago;
        this.fechaPago = fechaPago;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "idTicket=" + idTicket +
                ", codigoBarras='" + codigoBarras + '\'' +
                ", pago=" + pago +
                ", fechaPago=" + fechaPago +
                '}';
    }
}