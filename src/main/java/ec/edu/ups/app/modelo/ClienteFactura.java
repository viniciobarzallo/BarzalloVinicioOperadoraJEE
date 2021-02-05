/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.app.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author vinny
 */
@Entity
public class ClienteFactura {

    @Id
    private String cedula;

    private String nombre;
    private String numeroCelular;
    private double saldo;

    @JsonIgnore
    @OneToMany(mappedBy = "clientefactura")
    private List<RecargaFactura> recarga;

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }



    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public List<RecargaFactura> getRecarga() {
        return recarga;
    }

    public void setRecarga(List<RecargaFactura> recarga) {
        this.recarga = recarga;
    }

    
    
    
}
