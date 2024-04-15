/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DTO.PagoDTO;

/**
 *
 * @author INEGI
 */
public class PagoProvicional {

    private static PagoDTO pagoProvicional;

    public static PagoDTO getPagoProvicional() {
        return pagoProvicional;
    }

    public static void setPagoProvicional(PagoDTO pago) {
        pagoProvicional = pago;
    }
}
