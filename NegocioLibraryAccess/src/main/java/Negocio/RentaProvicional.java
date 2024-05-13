/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DTO.RentaDTO;

/**
 *
 * @author rober
 */
public class RentaProvicional {
    private static RentaDTO rentaProvicional;

    public static RentaDTO getRentaProvicional() {
        return rentaProvicional;
    }

    public static void setRentaProvicional(RentaDTO rentaProvicional) {
        RentaProvicional.rentaProvicional = rentaProvicional;
    }
}
