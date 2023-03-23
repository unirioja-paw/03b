package es.unirioja.servlet;

import bd.GestorBDImpl;
import es.unirioja.paw.model.Articulo;
import es.unirioja.paw.model.ExcepcionDeAplicacion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SqlInjectionServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/plain");
        Articulo articulo = null;
        String codigoArticulo = request.getParameter("cart");
        try {
            articulo = new GestorBDImpl().getArticulo(codigoArticulo);
        } catch (ExcepcionDeAplicacion ex) {
            Logger.getLogger(SqlInjectionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (articulo == null) {
            out.println("Articulo no encontrado");
            return;
        }
        out.println("Articulo: " + articulo.getNombre());
    }

    /*
        http://localhost:8080/Spike03b/sql?cart=Ede-402HO
        http://localhost:8080/Spike03b/sql?cart=%27%20or%201=1%20or%20%27%20
     */
}
