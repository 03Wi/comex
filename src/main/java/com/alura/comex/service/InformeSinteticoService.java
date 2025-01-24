package com.alura.comex.service;

import com.alura.comex.util.informe.InformeSintetico;
import com.alura.comex.model.Pedido;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

public class InformeSinteticoService {

    public InformeSintetico generarInformeSintetico(List<Pedido> pedidos){

        int cantidadTotalDeProductosVendidos = calcularTotalDeProductosVendidos(pedidos);
        BigDecimal montoTotalDeVentas = calcularMontoDeVentas(pedidos);
        int cantidadTotalDePedidosRealizados = calcularTotalDePedidosRealizados(pedidos);
        Pedido pedidoMasBarato = calcularPedidoMasBarato(pedidos);
        Pedido pedidoMasCaro = calcularPedidoMasCaro(pedidos);
        int categorias = calcularTotalDeCategorias(pedidos).size();

        return new InformeSintetico(
                cantidadTotalDePedidosRealizados,
                cantidadTotalDeProductosVendidos,
                categorias,
                montoTotalDeVentas,
                pedidoMasBarato,
                pedidoMasCaro);
    }

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
