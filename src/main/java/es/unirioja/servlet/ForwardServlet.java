package es.unirioja.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        RequestDispatcher rd = request.getRequestDispatcher("/greeting.jsp");
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/greeting-inside.jsp");
        rd.forward(request, response);
    }

}
