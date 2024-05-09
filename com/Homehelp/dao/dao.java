package com.Homehelp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.Homehelp.modelo.clase;
import java.sql.DriverManager;

public class dao {

    public class ConexionMySQL {

        // Librería de MySQL
        public String driver = "com.mysql.jdbc.Driver";

        // Nombre de la base de datos
        public String database = "databasemovies";

        // Host
        public String hostname = "localhost";

        // Puerto
        public String port = "3306";

        // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
        public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";

        // Nombre de usuario
        public String username = "root";

        // Clave de usuario
        public String password = "123456789";

        public Connection conectarMySQL() {
            Connection conn = null;

            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(url, username, password);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }

            return conn;
        }

    }
}

//Codigo de INSERT PENDIENTE

// Query
sSQL =  "INSERT INTO USERS (first_name, last_name) VALUES (?, ?)";
// PreparedStatement
PreparedStatement pstm = conn.prepareStatement(sSQL);