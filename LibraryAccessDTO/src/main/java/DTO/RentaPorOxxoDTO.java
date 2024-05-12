/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author rober
 */
public class RentaPorOxxoDTO {

    private String codigoBarrasOxxo;

    public RentaPorOxxoDTO(String codigoBarrasOxxo) {
        this.codigoBarrasOxxo = codigoBarrasOxxo;
    }

    public String getCodigoBarrasOxxo() {
        return codigoBarrasOxxo;
    }

    public void setCodigoBarrasOxxo(String codigoBarrasOxxo) {
        this.codigoBarrasOxxo = codigoBarrasOxxo;
    }

    @Override
    public String toString() {
        return "RentaPorOxxoDTO{" + "codigoBarrasOxxo=" + codigoBarrasOxxo + '}';
    }

}
