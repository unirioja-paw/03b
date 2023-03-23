package es.unirioja.servlet;

import es.unirioja.db.GestorBDMock;
import es.unirioja.paw.model.Articulo;
import es.unirioja.paw.model.ExcepcionDeAplicacion;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    private final String loginJspLocation = "/WEB-INF/pages/login.jsp";
    private final String loggedJspLocation = "/WEB-INF/pages/logged.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        RequestDispatcher rd = request.getRequestDispatcher(loginJspLocation);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String userpasswd = request.getParameter("userpasswd");

        boolean authSucces = checkCredentials(username, userpasswd);

        request.setAttribute("username", username);
        request.setAttribute("loginSuccess", authSucces);

        String jspLocation = loginJspLocation;
        if (authSucces) {
            jspLocation = loggedJspLocation;
        }
        System.out.println("Username " + username + " success?" + authSucces);
        RequestDispatcher rd = request.getRequestDispatcher(jspLocation);
        rd.forward(request, response);
    }

    private boolean checkCredentials(String username, String userpasswd) {
        if (!"joda".equals(username)) {
            return false;
        }
        if (!"1234".equals(userpasswd)) {
            return false;
        }
        return true;
    }

}
