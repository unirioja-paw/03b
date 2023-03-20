package es.unirioja.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitLoopServlet extends HttpServlet {

    /*
    init() y init(ServletConfig) son dos metodos diferentes:
        - init(ServletConfig) es algo parecido a:
            public void init(ServletConfig config) throws ServletException {
                this.config. = config;
                init();
            }
     */
    @Override
    public void init() throws ServletException {
        Date now = new Date();
        System.out.println(now.toString() + ": init servlet...");
        init(null); // causara un bucle infinito
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/plain");
        PrintWriter out = res.getWriter();
        out.println("Thread: " + Thread.currentThread().getName());
    }

}
