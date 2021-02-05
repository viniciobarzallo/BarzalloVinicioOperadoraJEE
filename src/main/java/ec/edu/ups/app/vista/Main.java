/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.app.vista;

import ec.edu.ups.app.modelo.ClienteFactura;
import ec.edu.ups.app.modelo.Factura;
import ec.edu.ups.app.modelo.RecargaFactura;
import ec.edu.ups.app.on.ONGestion;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vinny
 */
@WebServlet("/sri")
public class Main extends HttpServlet {

    @Inject
    private ONGestion on;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("<h1>SRI</h1>");
        try {
            ClienteFactura cl = new ClienteFactura();
            cl.setCedula("0103343588");
            cl.setNombre("Raquel");
            cl.setNumeroCeular("099022323");
            cl.setSaldo(1.21);

            Factura f = new Factura();

            RecargaFactura recarga = new RecargaFactura();
            recarga.setClientefactura(cl);
            recarga.setFactura(f);
            recarga.setValor(23);

            f.setValor(recarga.getValor());

            cl.setSaldo(cl.getSaldo() + f.getValor());

            on.crearRecarga(recarga);
        } catch (Exception e) {
            response.getWriter().println("<h1>" + e.getMessage() + "</h1>");
        }
    }

}
