/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.app.on;

import ec.edu.ups.app.dao.DaoGestion;
import ec.edu.ups.app.modelo.RecargaFactura;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author vinny
 */
@Stateless
public class ONGestion {

    @Inject
    private DaoGestion daog;

    public void crearRecarga(RecargaFactura rfac) {
        daog.crearRecarga(rfac);
    }



}
