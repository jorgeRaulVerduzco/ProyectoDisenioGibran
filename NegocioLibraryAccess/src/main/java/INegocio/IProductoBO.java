/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package INegocio;

import DTO.ProductoDTO;
import java.util.List;

/**
 *
 * @author INEGI
 */
public interface IProductoBO {

    public void agregarProducto(ProductoDTO productoDTO);

    public List<ProductoDTO> buscarProductosPorNombre(String nombre);

    public List<ProductoDTO> listaProductos();

    public List<ProductoDTO> buscarProductosPorVendedor(String vendedor);

    public List<ProductoDTO> buscarProductosPorIsbn(int isbn);

    public List<ProductoDTO> buscarProductosPorCategoria(String categoria);

    public List<ProductoDTO> buscarProductosPorAutor(String autor);

}
