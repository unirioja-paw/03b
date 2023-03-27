package es.unirioja.servlet;

import com.github.javafaker.Faker;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RandomImageServlet extends HttpServlet {

    private final int buffSize = 1024;

    Faker faker = new Faker(new Locale("es"));

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter outPrintWriter = response.getWriter();
        outPrintWriter.println("This is a GET");

        response.setContentType("image/jpg");
        OutputStream out = response.getOutputStream();
        String imageFilename = getRandomImageFilename();
        String imagePath = "/assets/images/electrosa/aspirador/" + imageFilename;
        System.out.println("Image path: " + imagePath);
        InputStream in = null;
        try {
            in = getServletContext().getResourceAsStream(imagePath);
            copy(in, out);
        } finally {
            if (in != null) {
                in.close();
            }
        }
        System.out.println("Request done");
    }

    private String getRandomImageFilename() {
        String filename = String.format(
                "aspirador%02d.jpg",
                randomIntBetween(0, 18)
        );
        return filename;
    }

    private int randomIntBetween(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    private void copy(InputStream is, OutputStream os) throws IOException {
        if (is == null) {
            System.out.println("Cannot copy: InputStream is null");
            return;
        }
        byte buff[] = new byte[buffSize];
        int leidos = is.read(buff);
        while (leidos != -1) {
            os.write(buff, 0, leidos);
            leidos = is.read(buff);
        }
        os.flush();
    }

}
