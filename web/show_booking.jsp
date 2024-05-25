<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Mostrar Reservas</title>
</head>
<body>
<h2>Reservas</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Fecha</th>
        <th>Estado</th>
        <th>Comentario</th>
        <th>ID Usuario</th>
    </tr>
    <%
        try {
            // Realizar la conexión a la base de datos
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/homehelp", "root", "password");
            String sql = "SELECT * FROM reservas";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            // Iterar sobre los resultados y mostrarlos en la tabla
            while (resultSet.next()) {
    %>
    <tr>
        <td><%= resultSet.getInt("ID_Reserva") %></td>
        <td><%= resultSet.getTimestamp("Fecha") %></td>
        <td><%= resultSet.getString("Estado") %></td>
        <td><%= resultSet.getString("Comentario") %></td>
        <td><%= resultSet.getInt("ID_Usuario") %></td>
    </tr>
    <%
            }
            // Cerrar los recursos
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException("Error al procesar la consulta SQL", e);
        }
    %>
</table>
</body>
</html>
