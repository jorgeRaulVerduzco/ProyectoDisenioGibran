/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Dominio.PagoPorTarjeta;
import IDAO.IPagoPorTarjetaDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author INEGI
 */
public class PagoPorTarjetaDAO implements  IPagoPorTarjetaDAO {
  private static PagoPorTarjetaDAO instancia;
    private List<PagoPorTarjeta> listaPagosPorTarjeta;
    private int proximoId;

    private PagoPorTarjetaDAO() {
        this.listaPagosPorTarjeta = new ArrayList<>();
        this.proximoId = 1;
    }

    public static PagoPorTarjetaDAO getInstancia() {
        if (instancia == null) {
            instancia = new PagoPorTarjetaDAO();
        }
        return instancia;
    }

    @Override
    public void agregarPago(PagoPorTarjeta pago) {
        pago.setIdPago(proximoId);
        listaPagosPorTarjeta.add(pago);
        proximoId++;
    }
}
