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
public class ProductoDTO {
 private int isbn;
    private String titulo;
    private String autor;
    private String tipo;
    private String editorial;
    private double precio;
    private String categoria;
    private int cantidad;
    private List<ReseñaDTO> reseñas;

    public ProductoDTO() {
        reseñas = new ArrayList<>();
    }

    public ProductoDTO(int isbn, String titulo, String autor, String tipo, String editorial, double precio, String categoria, int cantidad) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.tipo = tipo;
        this.editorial = editorial;
        this.precio = precio;
        this.categoria = categoria;
        this.cantidad = cantidad;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public List<ReseñaDTO> getReseñas() {
        return reseñas;
    }

    public void setReseñas(List<ReseñaDTO> reseñas) {
        this.reseñas = reseñas;
    }

    @Override
    public String toString() {
        return "ProductoDTO{" + "isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + ", tipo=" + tipo + ", editorial=" + editorial + ", precio=" + precio + ", categoria=" + categoria + ", cantidad=" + cantidad + ", rese\u00f1as=" + reseñas + '}';
    }

}
