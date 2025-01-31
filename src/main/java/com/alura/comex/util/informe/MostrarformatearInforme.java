package com.alura.comex.util.informe;

import com.alura.comex.model.InformeSintetico;
import com.alura.comex.model.Pedido;
import com.alura.comex.service.InformeSinteticoCalculadoraService;
import com.alura.comex.util.factory.ArchivoFactory;
import com.alura.comex.util.strategy.ArchivoProcesadorContext;
import com.alura.comex.util.strategy.IExtractorStrategy;

import java.util.List;

public class MostrarformatearInforme {

    private ArchivoProcesadorContext context = new ArchivoProcesadorContext();
    private List<Pedido> pedidos;
    private InformeSinteticoCalculadoraService calculadora = new InformeSinteticoCalculadoraService();
    private CrearInformeSintetico informeSinteticoService = new CrearInformeSintetico(this.calculadora);

    public void analisarArchivoGenerarInforme(String path) {

        IExtractorStrategy
                strategy = ArchivoFactory.getStrategy(path);
        this.context.setStrategy(strategy);
        this.pedidos = context.procesadorArchivo(path);
        InformeSintetico
                informeSintetico = informeSinteticoService.generarInformeSintetico(pedidos);
        InformeSinteticoFormatter.formatter(informeSintetico);
    }
}
