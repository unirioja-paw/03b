package es.unirioja.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ParameterVsArgumentServlet", urlPatterns = {"/ParameterVsArgumentServlet"})
public class ParameterVsArgumentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("ParameterVsArgumentServlet.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Parameter:
        // - Son de tipo String
        // - Son de solo lectura; no hay setParameter

        // - Llegan a nuestra aplicacion a traves de la request
        // - O tambien de parametros en web.xml (@see InitParameterServlet)
        String userNameP = request.getParameter("username");
        if (userNameP == null) {
            System.out.println("Parameter username is null or empty");
        } else {
            System.out.println("Parameter username: " + userNameP);
        }

        // Attribute:
        // - Son de tipo Object => casting
        // - Se pueden modificar, añadir, quitar, etc
        // - Vinculados a los diferentes scopes
        String userNameA = (String) request.getAttribute("username");
        if (userNameA == null) {
            System.out.println("Attribute username is null or empty");
        } else {
            System.out.println("Attribute username: " + userNameA);
        }

    }

}
