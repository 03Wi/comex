package com.alura.comex;

import com.alura.comex.util.ProcesadorCSV;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException {

        ArrayList<Pedido> pedidos = ProcesadorCSV.extractData("pedidos.csv");
        int totalDeProductosVendidos = InformeSintetico.totalDeProductosVendidos(pedidos);

        int totalDePedidosRealizados = InformeSintetico.totalDePedidosRealizados(pedidos);
        BigDecimal montoDeVentas = InformeSintetico.montoDeVentas(pedidos);

        Pedido pedidoMasBarato = InformeSintetico.pedidoMasBarato(pedidos);
        Pedido pedidoMasCaro = InformeSintetico.pedidoMasCaro(pedidos);

        List<String> categoriasProcesadas = new ArrayList<>();
        categoriasProcesadas.addAll(InformeSintetico.totalDeCategorias(pedidos));
        int totalDeCategorias = categoriasProcesadas.size();

        InformeSintetico informeSintetico = new InformeSintetico(
                totalDePedidosRealizados,
                totalDeProductosVendidos,
                totalDeCategorias,
                montoDeVentas,
                pedidoMasBarato,
                pedidoMasCaro);

        informeSintetico.show();
    }

}
