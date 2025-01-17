package com.alura.comex;

import com.alura.comex.service.InformeSinteticoService;
import com.alura.comex.util.InformeSinteticoFormatter;
import com.alura.comex.util.ProcesadorCSV;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException {

        ArrayList<Pedido> pedidos = ProcesadorCSV.extractData("pedidos.csv");

        InformeSinteticoService
                informeSinteticoService = new InformeSinteticoService();
        InformeSintetico
                informeSintetico = informeSinteticoService.generarInformeSintetico(pedidos);

        InformeSinteticoFormatter.show(informeSintetico);
    }

}
