package es.unirioja.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CuidadoCicloVidaServlet extends HttpServlet {

    private int count;  //Cuidado, es el mismo para todas las peticiones
    private int edad;

    private int randomIntBetween(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/plain");
        PrintWriter out = res.getWriter();

        int randomInt = randomIntBetween(1, 10);

        // NO es necesario guardar el contador en BD o un fichero.
        // Esta misma instancia servirá el resto de las peticiones.
        count++;

        sleepRandomTime();
        out.println("Thread: " + Thread.currentThread().getName());
        out.println("Count: " + count);
        updateEdad(req);
    }

    private void updateEdad(HttpServletRequest req) {
        edad = Integer.valueOf(req.getParameter("edad"));
        sleepRandomTime();
        if (req.getParameter("edad") == null || req.getParameter("edad").isEmpty()) {
            System.out.println("edad null or empty");
            return;
        }

        String personaId = req.getParameter("id");

        System.out.println("update PERSONA set edad " + edad + " where ID=" + personaId);
    }

    private void sleepRandomTime() {
        int randomInt = randomIntBetween(1, 10);
        System.out.println(Thread.currentThread().getName() + ": sleeping for " + randomInt + " seconds");
        try {
            Thread.sleep(randomInt * 1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(CuidadoCicloVidaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
