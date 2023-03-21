package es.unirioja.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendErrorServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
//        res.setContentType("text/plain");
        res.sendError(HttpServletResponse.SC_FORBIDDEN, "Cannot accept this");
    }
    
}
