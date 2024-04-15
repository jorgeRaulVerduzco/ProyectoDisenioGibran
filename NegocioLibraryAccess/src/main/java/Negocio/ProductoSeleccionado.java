/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DTO.ProductoDTO;

/**
 *
 * @author INEGI
 */
public class ProductoSeleccionado {
    private static ProductoDTO productoSeleccionado;
    
    public static ProductoDTO getPersonaSeleccionada() {
        return productoSeleccionado;
    }

    public static void setPersonaSeleccionada(ProductoDTO producto) {
        productoSeleccionado = producto;
    }
}
