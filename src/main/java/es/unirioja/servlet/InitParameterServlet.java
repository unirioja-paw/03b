package es.unirioja.servlet;

import java.io.IOException;
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
        String versionId_initParam = getInitParameter("version");
        String versionId_contextParam = request.getServletContext().getInitParameter("version");

        PrintWriter out = response.getWriter();
        response.setContentType("text/plain");
        out.println("Version (init-param): " + versionId_initParam);
        out.println("Version (context-param): " + versionId_contextParam);
    }

}
