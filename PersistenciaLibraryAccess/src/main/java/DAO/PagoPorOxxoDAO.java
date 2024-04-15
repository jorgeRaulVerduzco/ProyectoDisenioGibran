/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Dominio.PagoPorOxxo;
import IDAO.IPagoPorOxxo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author INEGI
 */
public class PagoPorOxxoDAO implements IPagoPorOxxo{
     private static PagoPorOxxoDAO instancia;
    private List<PagoPorOxxo> listaPagosPorOxxo;
    private int proximoId;

    private PagoPorOxxoDAO() {
        this.listaPagosPorOxxo = new ArrayList<>();
        this.proximoId = 1;
    }

    public static PagoPorOxxoDAO getInstancia() {
        if (instancia == null) {
            instancia = new PagoPorOxxoDAO();
        }
        return instancia;
    }

    @Override
    public void agregarPago(PagoPorOxxo pago) {
        pago.setIdPago(proximoId);
        listaPagosPorOxxo.add(pago);
        proximoId++;
    }
}
