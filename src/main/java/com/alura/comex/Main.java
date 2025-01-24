package com.alura.comex;

import com.alura.comex.model.Pedido;
import com.alura.comex.service.InformeSinteticoService;
import com.alura.comex.util.factory.ArchivoFactory;
import com.alura.comex.util.informe.InformeSintetico;
import com.alura.comex.util.strategy.ArchivoProcesadorContext;
import com.alura.comex.util.strategy.IExtractorStrategy;
import com.alura.comex.util.informe.InformeSinteticoFormatter;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args)  {

        ArchivoProcesadorContext context = new ArchivoProcesadorContext();
        IExtractorStrategy strategy = ArchivoFactory.getStrategy("pedidos.csv");
        context.setStrategy(strategy);
        ArrayList<Pedido> pedidos = context.procesadorArchivo("pedidos.csv");

        InformeSinteticoService
                informeSinteticoService = new InformeSinteticoService();
        InformeSintetico
                informeSintetico = informeSinteticoService.generarInformeSintetico(pedidos);

        InformeSinteticoFormatter.show(informeSintetico);
    }

}
