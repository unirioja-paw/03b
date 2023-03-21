package es.unirioja.servlet;

import es.unirioja.paw.model.ExcepcionDeAplicacion;
import es.unirioja.db.GestorBDMock;
import es.unirioja.paw.model.Articulo;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FichaArticuloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String cart = request.getParameter("cart");
        if (cart == null || cart.trim().isEmpty()) {
            response.sendRedirect("index.jsp");
            return;
        }
        try {
            Articulo art = new GestorBDMock().getArticulo(cart);
            if (art == null) {
                response.sendError(404, "Artículo inexistente");
            }
            request.setAttribute("art", art);
            RequestDispatcher rd = request.getRequestDispatcher("fichaArticulo.jsp");
            rd.forward(request, response);
        } catch (ExcepcionDeAplicacion ex) {
            throw new ServletException(ex);
        }

    }
}
