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
        int totalDeProductosVendidos = pedidos.stream()
                .mapToInt(Pedido::getCantidad)
                .sum();

        int totalDePedidosRealizados = pedidos.size();
        BigDecimal montoDeVentas = pedidos.stream()
                .map(pedido -> pedido.getValorTotal())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Pedido pedidoMasBarato =
                pedidos.stream()
                .min(Comparator.comparing(pedido ->
                        pedido.getPrecio()
                                .multiply(new BigDecimal(pedido.getCantidad()))))
                .orElse(new Pedido());

        Pedido pedidoMasCaro = pedidos.stream()
                .max(Comparator.comparing(pedido ->
                        pedido.getPrecio()
                                .multiply(new BigDecimal(pedido.getCantidad()))))
                .orElse(new Pedido());

        List<String> categoriasProcesadas = new ArrayList<>(pedidos.stream()
                .map(Pedido::getCategoria)
                .distinct()
                .toList());
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
