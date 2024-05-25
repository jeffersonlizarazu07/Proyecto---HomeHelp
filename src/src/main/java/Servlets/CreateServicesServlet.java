package src.main.java.Servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/create_services")
    public class CreateServicesServlet extends HttpServlet {
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws IOException {
            // Obtener los parámetros del formulario HTML
            String tipo = request.getParameter("tipo");
            String descripcion = request.getParameter("descripcion");
            String precio = request.getParameter("precio");
            int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));

            // Definir la conexión y la declaración fuera del bloque try-with-resources para poder cerrarlas correctamente
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/homehelp", "root", "password")) {
                // Define la consulta con marcadores de posición
                String sql = "INSERT INTO servicios (ID_Servicio, Tipo, Descripcion, Precio, ID_Usuario) " +
                        "VALUES (DEFAULT, ?, ?, ?, ?)";
                // Prepara la declaración
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    // Establece los valores de los parámetros
                    statement.setString(1, tipo);
                    statement.setString(2, descripcion);
                    statement.setDouble(3, Double.parseDouble(precio));
                    statement.setInt(4, idUsuario);
                    // Ejecuta la consulta
                    statement.executeUpdate();
                }
                // Indica que el servicio se ha creado con éxito
                response.getWriter().println("Servicio creado con éxito");
            } catch (SQLException e) {
                e.printStackTrace();
                // En caso de error, indica que ha ocurrido un error al crear el servicio
                response.getWriter().println("Error al crear servicio");
            }
        }
    }
