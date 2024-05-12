/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HistorialResenias;

import IHistorialResenias.IReseniasUsuario;
import INegocio.IReseñaBO;
import Negocio.ReseñaBO;
import java.util.List;

/**
 *
 * @author JORGE
 */
public class ReseniasUsuario implements IReseniasUsuario {

    IReseñaBO reseñaBO;

    public ReseniasUsuario() {
        reseñaBO = new ReseñaBO();
    }

    @Override
    public List<Object> obtenerReseñasDeUsuario(String nombreUsuario) {
        return reseñaBO.obtenerReseñasDeUsuario(nombreUsuario);
    }

}
