package MySQL;

import java.util.logging.*;
import java.lang.Exception;
import java.lang.String;

public class MyLogger {
    // Obtener una instancia del logger para la clase actual
    private static final Logger logger = Logger.getLogger(MyLogger.class.getName());

    // Configurar el nivel de registro predeterminado (puedes ajustarlo según tus necesidades)
    static {
        logger.setLevel(Level.INFO);
    }

    // Método para registrar errores
    public static void logError(Exception e) {
        logger.log(Level.SEVERE, "Error: " + e.getMessage(), e);
    }

    // Método para registrar mensajes de información
    public static void logInfo(String message) {
        logger.log(Level.INFO, message);
    }
}