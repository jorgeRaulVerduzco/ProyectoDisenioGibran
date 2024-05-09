/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ReseñaPorProducto;

import INegocio.IReseñaBO;
import IReseñasPorProducto.IReseñasProducto;
import Negocio.ReseñaBO;
import java.util.List;

/**
 *
 * @author INEGI
 */
public class ReseñasProducto implements IReseñasProducto {

    IReseñaBO reseñaBO;

    public ReseñasProducto() {
        reseñaBO = new ReseñaBO();
    }

    @Override
    public List<Object> obtenerReseñasDeProducto(int isbn) {
        return reseñaBO.obtenerReseñasDeProducto(isbn);
    }
}
