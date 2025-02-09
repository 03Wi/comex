package com.alura.comex;

import com.alura.comex.util.informe.MostrarformatearInforme;

import javax.swing.*;

public class Main {

    public static void main(String[] args)  {

        String name = getOption();
        MostrarformatearInforme informeSintetico = new MostrarformatearInforme();
        informeSintetico
                .analisarArchivoGenerarInforme(name);
    }

    private static String getOption() {
        String[] opciones = {"pedidos.xml", "pedidos.csv", "pedidos.json"};
        int seleccion = JOptionPane.showOptionDialog(
                null,
                "Seleccione una opción:",
                "Menú de archivos",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );
        String name = opciones[seleccion];
        return name;
    }

}
