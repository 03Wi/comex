package com.alura.comex;

import com.alura.comex.model.Pedido;
import com.alura.comex.service.InformeSinteticoCalculadoraService;
import com.alura.comex.util.informe.CrearInformeSintetico;
import com.alura.comex.util.factory.ArchivoFactory;
import com.alura.comex.model.InformeSintetico;
import com.alura.comex.util.informe.MostrarformatearInforme;
import com.alura.comex.util.strategy.ArchivoProcesadorContext;
import com.alura.comex.util.strategy.IExtractorStrategy;
import com.alura.comex.util.informe.InformeSinteticoFormatter;

import java.util.List;

public class Main {

    public static void main(String[] args)  {

        MostrarformatearInforme informeSintetico
                = new MostrarformatearInforme();
        informeSintetico.analisarArchivoGenerarInforme("pedidos.xml");
    }

}
