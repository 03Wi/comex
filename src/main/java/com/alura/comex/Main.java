package com.alura.comex;

import com.alura.comex.util.informe.MostrarformatearInforme;

public class Main {

    public static void main(String[] args)  {

        MostrarformatearInforme informeSintetico = new MostrarformatearInforme();
        informeSintetico
                .analisarArchivoGenerarInforme("pedidos.json");
    }

}
