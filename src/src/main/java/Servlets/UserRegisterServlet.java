package src.main.java.Servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;


@WebServlet("/user_register")
public class UserRegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        request.setCharacterEncoding("UTF-8"); // Establecer la codificación UTF-8 para la solicitud

        // Obtener los parámetros del formulario HTML
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String password = request.getParameter("contraseña"); // Obtener el valor de la contraseña

        // Definir la conexión y la declaración fuera del bloque try-catch para poder cerrarlos en el bloque finally
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Establecer la conexión con la base de datos
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/homehelp", "root", "password");

            // Definir la consulta con marcadores de posición
            String sql = "INSERT INTO usuario (Nombre, Correo_Electronico, Contraseña, Fecha_Registro, Tipo_Usuario) " +
                    "VALUES (?, ?, ?, ?, ?)";

            // Preparar la declaración
            statement = connection.prepareStatement(sql);

            // Establecer los valores de los parámetros
            statement.setString(1, nombre ); // Nombre
            statement.setString( 2, correo); // Correo electrónico
            statement.setString(3, password); // Contraseña
            statement.setString(4, request.getParameter("tipo_usuario"));
            statement.executeUpdate();
            response.sendRedirect("index.jsp");

            // Ejecutar la consulta
            statement.executeUpdate();

            // Indicar que el usuario se ha registrado con éxito
            response.getWriter().println("Usuario registrado con éxito");
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error al registrar usuario");
        } finally {
            // Cerrar la conexión y la declaración en un bloque finally para asegurar que se cierren correctamente
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}



