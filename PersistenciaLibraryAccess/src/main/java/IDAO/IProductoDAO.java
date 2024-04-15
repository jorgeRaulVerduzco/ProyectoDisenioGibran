/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IDAO;

import Dominio.Producto;
import java.util.List;

/**
 *
 * @author INEGI
 */
public interface IProductoDAO {
public void agregarProducto(Producto producto);    
    public List<Producto> obtenerTodosProductos();
    public List<Producto> buscarProductosPorNombre(String nombre);
}
