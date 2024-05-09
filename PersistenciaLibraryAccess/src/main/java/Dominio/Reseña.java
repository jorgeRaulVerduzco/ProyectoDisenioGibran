/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import org.bson.types.ObjectId;

/**
 *
 * @author INEGI
 */
public class Reseña {
    private ObjectId idReseña;
    private String reseña;
    private Integer rating;
    private Producto producto;
    Usuario usuario;

    public Reseña() {
    }

    public ObjectId getIdReseña() {
        return idReseña;
    }

    public void setIdReseña(ObjectId idReseña) {
        this.idReseña = idReseña;
    }

    public String getReseña() {
        return reseña;
    }

    public void setReseña(String reseña) {
        this.reseña = reseña;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Rese\u00f1a{" + "idRese\u00f1a=" + idReseña + ", rese\u00f1a=" + reseña + ", rating=" + rating + ", producto=" + producto + ", usuario=" + usuario + '}';
    }
    
    
    
}
