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

    private ObjectId id;
    private String codigoBarrasOxxo;

    public PagoPorOxxo(ObjectId id, String codigoBarrasOxxo) {
        this.id = id;
        this.codigoBarrasOxxo = codigoBarrasOxxo;
    }

    public PagoPorOxxo(ObjectId _id) {
        this.id = id;
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
        return id;
    }

    public void setIdOxxo(ObjectId _id) {
        this.id = _id;
    }

    @Override
    public String toString() {
        return "PagoPorOxxo{" + "idOxxo=" + id + ", codigoBarrasOxxo=" + codigoBarrasOxxo + '}';
    }

}
