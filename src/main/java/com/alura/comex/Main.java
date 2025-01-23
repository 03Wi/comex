package com.alura.comex;

import com.alura.comex.service.InformeSinteticoService;
import com.alura.comex.util.InformeSinteticoFormatter;
import com.alura.comex.util.ProcesadorCSV;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args)  {

        ArrayList<Pedido> pedidos = ProcesadorCSV.extract("pedidos.csv");
        InformeSinteticoService
                informeSinteticoService = new InformeSinteticoService();
        InformeSintetico
                informeSintetico = informeSinteticoService.generarInformeSintetico(pedidos);

        InformeSinteticoFormatter.show(informeSintetico);
    }

}
