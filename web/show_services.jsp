<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Mostrar Servicios</title>
</head>
<body>
<h2>Servicios Disponibles</h2>
<%
    Connection connection;
    try {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/homehelp", "root",
                "password");
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    String sql = "SELECT * FROM servicios";
    PreparedStatement statement;
    try {
        statement = connection.prepareStatement(sql);
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    ResultSet resultSet;
    try {
        resultSet = statement.executeQuery();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
%>
    <tr>
        <th>ID</th>
        <th>Tipo</th>
        <th>Descripción</th>
        <th>Precio</th>
        <th>ID Usuario</th>
    </tr>
    <%
        while (true) {
            try {
                if (!resultSet.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    %>
    <tr>

    </tr>
    <%
        }
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    %>


</body>
</html>
