package com.alura.comex;

import com.alura.comex.model.Pedido;
import com.alura.comex.service.InformeSinteticoCalculadoraService;
import com.alura.comex.util.informe.GenerarInformeSintetico;
import com.alura.comex.util.factory.ArchivoFactory;
import com.alura.comex.model.InformeSintetico;
import com.alura.comex.util.strategy.ArchivoProcesadorContext;
import com.alura.comex.util.strategy.IExtractorStrategy;
import com.alura.comex.util.informe.InformeSinteticoFormatter;

import java.util.List;

public class Main {

    public static void main(String[] args)  {

//        json();
        csv();
//        ArchivoProcesadorContext context = new ArchivoProcesadorContext();
//        IExtractorStrategy strategy = ArchivoFactory.getStrategy("pedidos.xml");
//        context.setStrategy(strategy);
//        System.out.println(context.procesadorArchivo("pedidos.xml"));
    }

    private static void csv() {
        ArchivoProcesadorContext context = new ArchivoProcesadorContext();
        IExtractorStrategy strategy = ArchivoFactory.getStrategy("pedidos.csv");
        context.setStrategy(strategy);
        List<Pedido> pedidos = context.procesadorArchivo("pedidos.csv");

        InformeSinteticoCalculadoraService calculadora = new InformeSinteticoCalculadoraService();

        GenerarInformeSintetico
                informeSinteticoService = new GenerarInformeSintetico(calculadora);

        InformeSintetico
                informeSintetico = informeSinteticoService.generarInformeSintetico(pedidos);

        InformeSinteticoFormatter.show(informeSintetico);
    }

    private static void json() {
        ArchivoProcesadorContext context = new ArchivoProcesadorContext();
        IExtractorStrategy strategy = ArchivoFactory.getStrategy("pedidos.json");
        context.setStrategy(strategy);
        System.out.println(context.procesadorArchivo("pedidos.json"));
    }

}
