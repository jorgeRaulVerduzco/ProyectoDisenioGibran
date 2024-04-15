/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAO.ProductoDAO;
import DTO.ProductoDTO;
import Dominio.Producto;
import IDAO.IProductoDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author INEGI
 */
public class ListaProductosBO {

    private IProductoDAO productoDAO;

    public ListaProductosBO() {
        productoDAO = ProductoDAO.getInstancia();
    }

    public List<ProductoDTO> listaProductos() {
        List<Producto> productos = productoDAO.obtenerTodosProductos();
        List<ProductoDTO> productosDTO = new ArrayList<>();

        for (Producto producto : productos) {
            ProductoDTO productoDTO = convertirAProductoDTO(producto);
            productosDTO.add(productoDTO);
        }

        return productosDTO;
    }

    private ProductoDTO convertirAProductoDTO(Producto producto) {
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setIsbn(producto.getIsbn());
        productoDTO.setTitulo(producto.getTitulo());
        productoDTO.setAutor(producto.getAutor());
        productoDTO.setTipo(producto.getTipo());
        productoDTO.setEditorial(producto.getEditorial());
        productoDTO.setPrecio(producto.getPrecio());
        productoDTO.setValoracion(producto.getValoracion());
        productoDTO.setCategoria(producto.getCategoria());
        productoDTO.setCantidad(producto.getCantidad());
        return productoDTO;
    }

    @Override
    public String toString() {
        List<ProductoDTO> productosDTO = listaProductos();
        int totalProductos = productosDTO.size();

        StringBuilder sb = new StringBuilder();
        sb.append("ListaProductosBO{");
        sb.append("totalProductos=").append(totalProductos);

        if (!productosDTO.isEmpty()) {
            sb.append(", primerosProductos=").append(productosDTO.subList(0, Math.min(5, totalProductos)));
        }

        sb.append('}');
        return sb.toString();
    }
}
