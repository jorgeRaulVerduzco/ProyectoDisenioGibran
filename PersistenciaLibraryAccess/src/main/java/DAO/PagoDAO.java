/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Dominio.Pago;
import Dominio.Producto;
import IDAO.IPagoDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author INEGI
 */
public class PagoDAO implements IPagoDAO {

    private static PagoDAO instancia;
    private List<Pago> listaPagos;
    private int proximoId;

    private PagoDAO() {
        this.listaPagos = new ArrayList<>();
        this.proximoId = 1;
    }

    public static PagoDAO getInstancia() {
        if (instancia == null) {
            instancia = new PagoDAO();
        }
        return instancia;
    }

    @Override
    public void agregarPago(Pago pago) {
        pago.setIdPago(proximoId);
        listaPagos.add(pago);

        // Restar la cantidad de libros vendidos del inventario
        Producto libroVendido = pago.getProducto();
        libroVendido.restarCantidad(pago.getCantidad());
        proximoId++;
    }
}
