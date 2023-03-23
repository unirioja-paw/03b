package es.unirioja.servlet;

import com.github.javafaker.Faker;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OutputBufferServlet extends HttpServlet {

    Faker faker = new Faker(new Locale("es"));

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("BufferSize: " + response.getBufferSize());

        for (int i = 0; i < 500; i++) {
            String iterationMessage = String.format("Iteration=%s", i);
            System.out.println(iterationMessage);
            printBufferInfo(response);
            out.println(iterationMessage + ": " + faker.book().title());
        }
    }

    private void printBufferInfo(HttpServletResponse response) {
        System.out.println("Buffer is commited? " + response.isCommitted());
        System.out.println("---");
    }

}
