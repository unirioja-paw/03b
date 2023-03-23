package es.unirioja.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitParameterServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String versionId = getInitParameter("version");
        PrintWriter out = response.getWriter();
        response.setContentType("text/plain");
        out.println("Servlet version: " + versionId);
    }

}
