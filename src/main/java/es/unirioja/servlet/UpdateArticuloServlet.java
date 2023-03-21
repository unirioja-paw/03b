package es.unirioja.servlet;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import es.unirioja.paw.model.Articulo;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;

public class UpdateArticuloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
//        response.setContentType("application/json; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(buildJsonResponse());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String requestString = IOUtils.toString(request.getInputStream(), Charset.defaultCharset());
        Gson gson = new Gson();
        System.out.println("Request: " + requestString);
        Articulo articulo = gson.fromJson(requestString, Articulo.class);
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.println("Articulo:");
        out.println("Nombre: " + articulo.getNombre());
        out.println("Descripcion: " + articulo.getDescripcion());
        out.println("Fabricante: " + articulo.getFabricante());

    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
//        response.setContentType("application/json; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(buildJsonResponse());
    }

    private Articulo mockArticulo() {
        Articulo a = new Articulo();
        Faker faker = new Faker(new Locale("es"));
        a.setNombre(faker.commerce().productName());
        a.setFabricante(faker.company().name());
        a.setDescripcion(faker.yoda().quote());
        a.setFoto("aspirador00.jpg");
        return a;
    }

    private String buildJsonResponse() {
        Gson gson = new Gson();
        String result = gson.toJson(mockArticulo());
        return result;
    }

}
