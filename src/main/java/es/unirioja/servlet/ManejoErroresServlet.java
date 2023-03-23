package es.unirioja.servlet;

import es.unirioja.paw.model.Articulo;
import es.unirioja.paw.model.ExcepcionDeAplicacion;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManejoErroresServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            buscarArticulo("aaaa");
        } catch (ExcepcionDeAplicacion ex) {
            throw new ServletException(ex);
        }
    }

    private Articulo buscarArticulo(String codigo) throws ExcepcionDeAplicacion {
        throw new ExcepcionDeAplicacion("Fuera de plazo");
    }

}
