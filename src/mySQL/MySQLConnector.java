package mySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class MySQLConnector {

    public static void main(String[] args) {
        // Crear una instancia de MySQLConnector y ejecutar la conexión y consulta
        MySQLConnector connector = new MySQLConnector();
        connector.connectAndQuery();
    }

    // Método para conectar a la base de datos y ejecutar una consulta
    public void connectAndQuery() {
        Connection conn = null;
        String driver = "com.mysql.cj.jdbc.Driver";

        try {
            // Cargar el controlador JDBC de MySQL
            Class.forName(driver);
            System.out.println("Driver cargado exitosamente.");

            try {
                // Configurar los parámetros para la conexión
                Properties props = new Properties();
                props.setProperty("user", "root");
                props.setProperty("password", "admin");
                props.setProperty("useSSL", "true"); // Habilitar SSL
                props.setProperty("serverTimezone", "UTC");
                props.setProperty("useUnicode", "true");
                props.setProperty("useJDBCCompliantTimezoneShift", "true");
                props.setProperty("useLegacyDatetimeCode", "false");

                // Establecer la conexión
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/homehelp", props);
                if (conn != null) {
                    System.out.println("Conexión exitosa.");

                    // Ejecutar una consulta SELECT
                    executeSelectQuery(conn);

                    // Ejecutar una inserción
                    executeInsertQuery(conn, 5, "Limpieza de Jardines", "Servicio de limpieza para jardines y áreas verdes", "50.00");

                    // Ejecutar una actualización
                    executeUpdateQuery(conn, 7, "Juan Perez", "juan.perez@nuevoejemplo.com", "nuevaContraseña123", "2024-07-15", "Admin");

                    // Ejecutar una eliminación
                    executeDeleteQuery(conn, 5);

                    // Cerrar la conexión
                    conn.close();
                    System.out.println("Conexión cerrada.");
                }
            } catch (SQLException e) {
                System.out.println("Ha ocurrido un error al conectarse a la base de datos: " + e.getMessage());
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver: " + e.getMessage());
        }
    }

    // Método para ejecutar una consulta SELECT
    public static void executeSelectQuery(Connection conn) {
        String query = "SELECT * FROM servicios";
        try (PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int idServicio = rs.getInt("ID_Servicio");
                String tipo = rs.getString("Tipo");
                String descripcion = rs.getString("Descripcion");
                String precio = rs.getString("Precio");

                System.out.println("Id del Servicio: " + idServicio);
                System.out.println("Tipo de Servicio: " + tipo);
                System.out.println("Descripción del Servicio: " + descripcion);
                System.out.println("Precio del Servicio: " + precio);
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta SELECT: " + e.getMessage());
        }
    }

    // Método para ejecutar una inserción
    public static void executeInsertQuery(Connection conn, int idServicio, String tipo, String descripcion, String precio) {
        // Truncar la descripción si es necesario
        int maxDescripcionLength = 100; // Ajusta este valor al tamaño máximo permitido en tu base de datos
        if (descripcion.length() > maxDescripcionLength) {
            descripcion = descripcion.substring(0, maxDescripcionLength);
        }

        String insertQuery = "INSERT INTO servicios (ID_Servicio, Tipo, Descripcion, Precio) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {
            // Establecer los valores de los parámetros
            pstmt.setInt(1, idServicio);
            pstmt.setString(2, tipo);
            pstmt.setString(3, descripcion);
            pstmt.setString(4, precio);

            // Ejecutar la inserción
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Filas insertadas: " + rowsAffected);
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la inserción: " + e.getMessage());
        }
    }

    // Método para ejecutar una actualización
    public static void executeUpdateQuery(Connection conn, int idUsuario, String nombre, String correoElectronico, String contrasena, String fechaRegistro, String tipoUsuario) {
        String updateQuery = "UPDATE Usuario SET Nombre = ?, Correo_Electronico = ?, Contraseña = ?, Fecha_Registro = ?, Tipo_Usuario = ? WHERE ID_Usuario = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {
            // Establecer los valores de los parámetros
            pstmt.setString(1, nombre);
            pstmt.setString(2, correoElectronico);
            pstmt.setString(3, contrasena);
            pstmt.setString(4, fechaRegistro);
            pstmt.setString(5, tipoUsuario);
            pstmt.setInt(6, idUsuario);

            // Ejecutar la actualización
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Filas actualizadas: " + rowsAffected);
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la actualización: " + e.getMessage());
        }
    }

    // Método para ejecutar una eliminación
    public static void executeDeleteQuery(Connection conn, int idServicio) {
        String deleteQuery = "DELETE FROM servicios WHERE ID_Servicio = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(deleteQuery)) {
            // Establecer los valores de los parámetros
            pstmt.setInt(1, idServicio);

            // Ejecutar la eliminación
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Filas eliminadas: " + rowsAffected);
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la eliminación: " + e.getMessage());
        }
    }
}
