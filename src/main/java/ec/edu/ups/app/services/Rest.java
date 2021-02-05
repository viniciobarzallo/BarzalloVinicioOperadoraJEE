/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.app.services;

import ec.edu.ups.app.modelo.ClienteFactura;
import ec.edu.ups.app.modelo.Factura;
import ec.edu.ups.app.modelo.RecargaFactura;
import ec.edu.ups.app.on.ONGestion;
import java.io.IOException;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author vinny
 */
@Path("consumir")
public class Rest {

    @Inject
    private ONGestion on;

    @POST
    @Path("/ingresar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Respuesta crearProducto(Parametros p) throws IOException, Exception {
        Respuesta resp = new Respuesta();

        try {
            ClienteFactura clifac = p.getCliente();

            Factura f = new Factura();

            RecargaFactura recarga = p.getRecarga();
            recarga.setFactura(f);
            recarga.setClientefactura(clifac);
            f.setValor(recarga.getValor());
            resp.setCodigo(1);
            resp.setMensaje("Se registro exitosamente");

            clifac.setSaldo(clifac.getSaldo() + f.getValor());

            on.crearRecarga(recarga);

        } catch (Exception e) {
            resp.setCodigo(-1);
            resp.setMensaje("ERROR no hay suficiente valores");
            e.printStackTrace();
        }
        return resp;
    }

}
