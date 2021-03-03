package app.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SensorsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter writer = response.getWriter();
        // Get parameters
        String temp = request.getParameter("temp");
        String hum = request.getParameter("hum");

        try {
            writer.println("Temperature:" + temp);
            writer.println("Humidity:" + hum);
        } finally {
            writer.close();
        }
    }
}
