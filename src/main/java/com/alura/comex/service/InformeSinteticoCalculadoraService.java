package com.alura.comex.service;

import com.alura.comex.model.Categoria;
import com.alura.comex.model.Pedido;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

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

    public List<Categoria> calcularTotalVentasCategoria(List<Pedido> pedidos) {
        return pedidos.stream()
                .collect(groupingBy(Pedido::getCategoria,
                        collectingAndThen(
                                toList(),
                                list -> new Categoria(
                                        list.get(0).getCategoria(),
                                        list.stream().mapToInt(Pedido::getCantidad).sum(),
                                        list.stream().map(Pedido::getPrecio).reduce(BigDecimal.ZERO, BigDecimal::add)
                                )
                        )))
                .values()
                .stream()
                .sorted(Comparator.comparing(Categoria::getName))
                .toList();
    }

    public List<Pedido> calcularProductosMasVendidos(List<Pedido> pedidos) {

        return pedidos.stream()
                .sorted(Comparator
                        .comparing(Pedido::getCantidad).reversed())
                .limit(3)
                .toList();
    }

    public List<Pedido> calcularLosProductosMasCarosPorCategoria(List<Pedido> pedidos) {

        return pedidos.stream()
                .collect(Collectors.groupingBy(Pedido::getCategoria,
                        Collectors.collectingAndThen(
                                toList(),
                                list -> new Pedido(
                                        list.get(0).getCategoria(),
                                        list.stream()
                                                .max(Comparator.comparing(Pedido::getPrecio))
                                                .map(Pedido::getProducto).get(),
                                        list.stream()
                                                .max(Comparator.comparing(Pedido::getPrecio))
                                                .get().getPrecio()
                                )
                        )))
                .values()
                .stream()
                .sorted(Comparator.comparing(Pedido::getCategoria))
                .toList();
    }
}
