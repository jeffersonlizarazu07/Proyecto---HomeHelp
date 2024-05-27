package MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.lang.Exception;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class MySQLConnector {

    public static void main(String[] args) {
        Connect();
    }

    public static void Connect() {
        Connection conn;

        String driver = "com.mysql.cj.jdbc.Driver";

        try {
            // Cargar el controlador JDBC de MySQL
            Class.forName(driver);
            System.out.println("Driver cargado exitosamente.");

            try {
                // Configurar los parámetros para la conexión
                Properties props = getProperties();

                // Establecer la conexión
                conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/homehelp", props);
                if (conn != null) {
                    System.out.println("Conexión exitosa.");

                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM servicios");
                    while (rs.next()) {
                        int idServicio= rs.getInt(1);
                        String Tipo = rs.getString(2);
                        String Descripcion = rs.getString(3);
                        String Precio = rs.getString(4);

                        System.out.println("Id del Servico: " +idServicio);
                        System.out.println();
                        System.out.println("Tipo de Servicio: " + Tipo);
                        System.out.println();
                        System.out.println("Descripcion del Servicio: " + Descripcion);
                        System.out.println();
                        System.out.println("Precio del Servicio: " + Precio);

                        /*try {
            // Conecta a la base de datos
            conexion = DriverManager.getConnection(url, usuario, contrasena);

            // Prepara el SQL para la inserción
            String sql = "INSERT INTO reservas (Comentario, Estado, Fecha, ID_Reserva, ID-Usuario, TablaUsuario_ID_Usuario) VALUES (?, ?, ?)";
            declaracion = conexion.prepareStatement(sql);

            // Establece los valores
            declaracion.setString(1, "Solicitud de usuario para servicio");
            declaracion.setString(2, "Procesada");
            declaracion.setString(3, "2024-05-02);
            declaracion.setInt(4, 1);
            declaracion.setInt(5, 1);
            declaracion.setInt(6, 1);

            // Ejecuta la inserción
            int filasInsertadas = declaracion.executeUpdate();
            System.out.println(filasInsertadas + " registro(s) insertado(s)");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cierra la declaración y la conexión
            try {
                if (declaracion != null) declaracion.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
                        */
                        /*
                          try {
            // Conecta a la base de datos
            conexion = DriverManager.getConnection(url, usuario, contrasena);

            // Prepara el SQL para la actualización
            String sql = "UPDATE usuarios SET correo = ?, edad = ? WHERE nombre = ?";
            declaracion = conexion.prepareStatement(sql);

            // Establece los valores
            declaracion.setString(1, "juan.perez@nuevoejemplo.com");
            declaracion.setInt(2, 31);
            declaracion.setString(3, "Juan Perez");

            // Ejecuta la actualización
            int filasActualizadas = declaracion.executeUpdate();
            System.out.println(filasActualizadas + " registro(s) actualizado(s)");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cierra la declaración y la conexión
            try {
                if (declaracion != null) declaracion.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

}
                         */
                        /*
                           try {
            // Conecta a la base de datos
            conexion = DriverManager.getConnection(url, usuario, contrasena);

            // Prepara el SQL para la eliminación
            String sql = "DELETE FROM usuarios WHERE nombre = ?";
            declaracion = conexion.prepareStatement(sql);

            // Establece el valor del parámetro
            declaracion.setString(1, "Juan Perez");

            // Ejecuta la eliminación
            int filasEliminadas = declaracion.executeUpdate();
            System.out.println(filasEliminadas + " registro(s) eliminado(s)");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cierra la declaración y la conexión
            try {
                if (declaracion != null) declaracion.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
                         */
                    }
                }
            }catch (Exception e) {
                System.out.println("Ha ocurrido un error al conectarse a la base de datos: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al cargar el driver: " + e.getMessage());
        }
    }

    private static Properties getProperties() {
        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "admin");
        props.setProperty("useSSL", "true"); // Habilitar SSL
        props.setProperty("serverTimezone", "UTC");
        props.setProperty("useUnicode", "true");
        props.setProperty("useJDBCCompliantTimezoneShift", "true");
        props.setProperty("useLegacyDatetimeCode", "false");
        return props;
    }
}