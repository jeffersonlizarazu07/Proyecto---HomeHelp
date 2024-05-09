package com.Homehelp.main;

import com.Homehelp.dao.dao;
import com.Homehelp.modelo.clase;

public class Main {

    public static void main(String[] args) {
        // Ejemplo de uso del DAO
        dao claseDAO = new dao();

        // Insertar
        clase nuevaClase = new clase(/* datos */);
        dao.insertar(nuevaClase);

        // Consultar
        List<clase> clases = dao.consultarTodos();
        for (clase c : clases) {
            System.out.println(c);
        }

        // Actualizar
        clase claseExistente = clases.get(0);
        claseExistente.setAtributo1("Nuevo valor");
        claseDAO.actualizar(claseExistente);

        // Eliminar
        clasedao.eliminar(claseExistente.getId());
    }
}
