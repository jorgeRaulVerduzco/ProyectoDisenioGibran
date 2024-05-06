/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import org.bson.types.ObjectId;

/**
 *
 * @author INEGI
 */
public class PagoPorOxxo {

    private ObjectId idOxxo;
    private String codigoBarrasOxxo;

    public PagoPorOxxo(ObjectId idOxxo, String codigoBarrasOxxo) {
        this.idOxxo = idOxxo;
        this.codigoBarrasOxxo = codigoBarrasOxxo;
    }

    public PagoPorOxxo(ObjectId idOxxo) {
        this.idOxxo = idOxxo;
    }

    public PagoPorOxxo() {
    }

    public String getCodigoBarrasOxxo() {
        return codigoBarrasOxxo;
    }

    public void setCodigoBarrasOxxo(String codigoBarrasOxxo) {
        this.codigoBarrasOxxo = codigoBarrasOxxo;
    }

    public ObjectId getIdOxxo() {
        return idOxxo;
    }

    public void setIdOxxo(ObjectId idOxxo) {
        this.idOxxo = idOxxo;
    }

    @Override
    public String toString() {
        return "PagoPorOxxo{" + "idOxxo=" + idOxxo + ", codigoBarrasOxxo=" + codigoBarrasOxxo + '}';
    }

}
