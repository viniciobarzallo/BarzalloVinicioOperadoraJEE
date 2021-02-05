/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.app.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author vinny
 */
@Entity
public class RecargaFactura {
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idrecarga;

    private double valor;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "cedula")
    private ClienteFactura clientefactura;

    
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "idfact")
    private Factura factura;

    public int getIdrecarga() {
        return idrecarga;
    }

    public void setIdrecarga(int idrecarga) {
        this.idrecarga = idrecarga;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public ClienteFactura getClientefactura() {
        return clientefactura;
    }

    public void setClientefactura(ClienteFactura clientefactura) {
        this.clientefactura = clientefactura;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    
    
    
}
