/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.app.dao;

import ec.edu.ups.app.modelo.RecargaFactura;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author vinny
 */
@Stateless
public class DaoGestion {

    @PersistenceContext
    private EntityManager em;

    public void crearRecarga(RecargaFactura rfac) {
        em.persist(rfac);
    }

    

}
