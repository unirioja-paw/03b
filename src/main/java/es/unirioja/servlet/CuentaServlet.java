package es.unirioja.servlet;

import es.unirioja.db.GestorBD;
import es.unirioja.db.GestorBDMock;
import es.unirioja.paw.model.Articulo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CuentaServlet extends HttpServlet {

    private GestorBD gbd;

    public void init() throws ServletException {
        super.init();
        gbd = (GestorBD) this.getServletContext().getAttribute("gbd");
        if (gbd == null) {
            gbd = new GestorBDMock();
            this.getServletContext().setAttribute("gbd", gbd);
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        List<Articulo> articulos = gbd.getArticulos();

        PrintWriter out = res.getWriter();
        if (articulos == null || articulos.isEmpty()) {
            out.println("articulos null or empty");
            return;
        }
        for (Articulo a : articulos) {
            out.println(a.getNombre());
        }
    }

}
