/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author INEGI
 */
public class Usuario {
 
    private ObjectId id;
    private String nombreUsuario;
    private String contraseña;
    private List<Producto> productosVendidos;

    public Usuario(ObjectId id, String nombreUsuario, String contraseña) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
    }

    public Usuario() {
        productosVendidos = new ArrayList<>();
    }


    public ObjectId getIdUsuario() {
        return id;
    }

    public void setIdUsuario(ObjectId id) {
        this.id = id;
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

    public List<Producto> getProductosVendidos() {
        return productosVendidos;
    }

    public void setProductosVendidos(List<Producto> productosVendidos) {
        this.productosVendidos = productosVendidos;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + id + ", nombreUsuario=" + nombreUsuario + ", contrasenia=" + contraseña + ", productosVendidos=" + productosVendidos + '}';
    }

}
