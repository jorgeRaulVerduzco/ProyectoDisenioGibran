/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author INEGI
 */
public class UsuarioDTO {

    private String nombreUsuario;
    private String contraseña;
    private List<ProductoDTO> productos;

    public UsuarioDTO(String nombreUsuario, String contraseña) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
    }

    public UsuarioDTO() {
        productos  = new ArrayList<>();
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public List<ProductoDTO> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoDTO> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" + ", nombreUsuario=" + nombreUsuario + ", contraseña=" + contraseña + '}';
    }

}
