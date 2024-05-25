<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Creación de Servicios</title>
</head>
<body>
<h2>Crear Servicio</h2>
<form method="post">
    <label for="tipo">Tipo de Servicio:</label>
    <input type="text" id="tipo" name="tipo" required><br><br>

    <label for="descripcion">Descripción:</label>
    <input type="text" id="descripcion" name="descripcion" required><br><br>

    <label for="precio">Precio:</label>
    <input type="number" step="0.01" id="precio" name="precio" required><br><br>

    <button type="submit">Crear Servicio</button>
</form>
</body>
</html>
