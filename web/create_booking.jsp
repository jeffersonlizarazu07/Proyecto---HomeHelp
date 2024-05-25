
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Crear Reserva</title>
</head>
<body>
<h2>Crear Reserva</h2>
<form method="post">
  <label for="fecha">Fecha y Hora:</label>
  <input type="datetime-local" id="fecha" name="fecha" required><br><br>

  <label for="estado">Estado:</label>
  <input type="text" id="estado" name="estado" required><br><br>

  <label for="comentario">Comentario:</label>
  <input type="text" id="comentario" name="comentario"><br><br>

  <label for="servicio">ID del Servicio:</label>
  <input type="number" id="servicio" name="servicio" required><br><br>

  <button type="submit">Hacer Reserva</button>
</form>

</body>
</html>
