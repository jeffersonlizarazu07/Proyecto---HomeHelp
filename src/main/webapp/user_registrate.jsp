<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registro de Usuario - HomeHelp</title>
</head>
<body>
<h2>Registro de Usuario</h2>
<form action="registroUsuario" method="post">
    <label for="nombre">Nombre:</label>
    <input type="text" id="nombre" name="nombre" required><br><br>

    <label for="correo">Correo Electrónico:</label>
    <input type="email" id="correo" name="correo" required><br><br>

    <label for="contraseña">Contraseña:</label>
    <input type="password" id="contraseña" name="contraseña" required><br><br>

    <button type="submit">Registrar</button>
</form>
</body>
</html>

