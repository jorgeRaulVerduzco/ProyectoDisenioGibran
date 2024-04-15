/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Dominio.Producto;
import IDAO.IProductoDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author INEGI
 */
public class ProductoDAO implements IProductoDAO{
   private static ProductoDAO instancia;
    private List<Producto> listaProductos;

    private ProductoDAO() {
        this.listaProductos = new ArrayList<>();
    }

    public static ProductoDAO getInstancia() {
        if (instancia == null) {
            instancia = new ProductoDAO();
        }
        return instancia;
    }

   @Override
    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
    }

   @Override
    public List<Producto> buscarProductosPorNombre(String nombre) {
        List<Producto> productosEncontrados = new ArrayList<>();
        for (Producto producto : listaProductos) {
            if (producto.getTitulo().equalsIgnoreCase(nombre)) {
                productosEncontrados.add(producto);
            }
        }
        return productosEncontrados;
    }
    
   

   @Override
    public List<Producto> obtenerTodosProductos() {
        return listaProductos;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de productos:\n");
        for (Producto producto : listaProductos) {
            sb.append(producto.toString()).append("\n");
        }
        return sb.toString();
    }
}
