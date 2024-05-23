<!DOCTYPE html>
<html>
<head>
    <title>Inicio</title>
</head>
<body>
<h1>Inicio</h1>
<c:if test="${not empty message}">
    <p>${message}</p>
</c:if>
<a href="user_registrate.jsp">Crear Usuario</a>
</body>
</html>
