package com.alura.comex.service;

import com.alura.comex.model.Pedido;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

public class InformeSinteticoCalculadoraService {

    public int calcularTotalDeProductosVendidos(List<Pedido> pedidos) {
        return pedidos.stream()
                .mapToInt(Pedido::getCantidad)
                .sum();
    }

    public BigDecimal calcularMontoDeVentas(List<Pedido> pedidos) {
        return pedidos.stream()
                .map(Pedido::getValorTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public int calcularTotalDePedidosRealizados(List<Pedido> pedidos) {
        return pedidos.size();
    }

    public Pedido calcularPedidoMasBarato(List<Pedido> pedidos) {
        return pedidos.stream()
                .min(Comparator.comparing(pedido ->
                        pedido.getPrecio()
                                .multiply(new BigDecimal(pedido.getCantidad()))))
                .orElse(new Pedido());
    }

    public Pedido calcularPedidoMasCaro(List<Pedido> pedidos) {
        return pedidos.stream()
                .max(Comparator.comparing(pedido ->
                        pedido.getPrecio()
                                .multiply(new BigDecimal(pedido.getCantidad()))))
                .orElse(new Pedido());
    }

    public List<String> calcularTotalDeCategorias(List<Pedido> pedidos) {
        return pedidos.stream()
                .map(Pedido::getCategoria)
                .distinct()
                .toList();
    }
}
