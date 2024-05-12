/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IDAO;

import Dominio.Producto;
import Excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author INEGI
 */
public interface IProductoDAO {

    public void agregarProducto(Producto producto) throws PersistenciaException;

    public List<Producto> obtenerTodosProductos() throws PersistenciaException;

    public List<Producto> buscarProductosPorNombre(String nombre) throws PersistenciaException;

    public List<Producto> buscarProductosPorVendedor(String vendedor) throws PersistenciaException;

    public List<Producto> buscarProductosPorIsbn(int isbn) throws PersistenciaException;

    public List<Producto> buscarProductosPorAutor(String autor) throws PersistenciaException;

    public List<Producto> buscarProductosPorCategoria(String categoria) throws PersistenciaException;
}
