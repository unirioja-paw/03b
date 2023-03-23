package es.unirioja.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RutaServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        // en JSP application.getRealPath(

        PrintWriter out = response.getWriter();
        response.setContentType("text/plain");
        String filename = "background-night.png";
        InputStream inputStream = getServletContext().getResourceAsStream(filename);
        String realPath = getServletContext().getRealPath(filename);
        out.println("RealPath: " + realPath);
        out.println("InputStream.isNull?: " + (inputStream == null));

    }

}
