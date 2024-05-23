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
                Properties props = new Properties();
                props.setProperty("user", "root");
                props.setProperty("password", "admin");
                props.setProperty("useSSL", "true"); // Habilitar SSL
                props.setProperty("serverTimezone", "UTC");
                props.setProperty("useUnicode", "true");
                props.setProperty("useJDBCCompliantTimezoneShift", "true");
                props.setProperty("useLegacyDatetimeCode", "false");

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
                    }
                }
            }catch (Exception e) {
                System.out.println("Ha ocurrido un error al conectarse a la base de datos: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al cargar el driver: " + e.getMessage());
        }
    }
}