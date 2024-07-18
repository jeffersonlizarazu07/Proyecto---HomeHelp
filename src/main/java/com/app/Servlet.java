package main.java.com.app;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L; //

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MyServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Bienvenidos a HomeHelp " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

        // Lógica para manejar solicitudes POST
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");

        if (nombre != null && !nombre.isEmpty() && email != null && !email.isEmpty()) {
            // Guardar usuario en base de datos (simulado aquí)
            // Redirigir o mostrar mensaje de éxito
            request.setAttribute("message", "Usuario creado exitosamente");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            // Manejo de error si los parámetros no están presentes o son inválidos
            request.setAttribute("error", "Nombre y correo electrónico son requeridos.");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

