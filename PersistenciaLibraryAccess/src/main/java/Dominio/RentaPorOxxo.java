/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import org.bson.types.ObjectId;

/**
 *
 * @author rober
 */
public class RentaPorOxxo {

    private ObjectId id;
    private String codigoBarrasOxxo;

    public RentaPorOxxo() {
    }

    public RentaPorOxxo(ObjectId id) {
        this.id = id;
    }

    public RentaPorOxxo(ObjectId id, String codigoBarrasOxxo) {
        this.id = id;
        this.codigoBarrasOxxo = codigoBarrasOxxo;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getCodigoBarrasOxxo() {
        return codigoBarrasOxxo;
    }

    public void setCodigoBarrasOxxo(String codigoBarrasOxxo) {
        this.codigoBarrasOxxo = codigoBarrasOxxo;
    }

    @Override
    public String toString() {
        return "RentaPorOxxo{" + "id=" + id + ", codigoBarrasOxxo=" + codigoBarrasOxxo + '}';
    }

}
