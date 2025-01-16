package com.alura.comex;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class InformeSintetico {

    private int totalDePedidosRealizados;
    private int  totalDeProductosVendidos;
    private int totalDeCategorias;
    private BigDecimal montoDeVentas;
    private Pedido pedidoMasBarato;
    private Pedido pedidoMasCaro;

    public InformeSintetico(int totalDePedidosRealizados, int totalDeProductosVendidos, int totalDeCategorias, BigDecimal montoDeVentas, Pedido pedidoMasBarato, Pedido pedidoMasCaro) {
        this.totalDePedidosRealizados = totalDePedidosRealizados;
        this.totalDeProductosVendidos = totalDeProductosVendidos;
        this.totalDeCategorias = totalDeCategorias;
        this.montoDeVentas = montoDeVentas;
        this.pedidoMasBarato = pedidoMasBarato;
        this.pedidoMasCaro = pedidoMasCaro;
    }

    public void show() {
        System.out.println("#### INFORME DE VALORES TOTALES");
        System.out.printf("- TOTAL DE PEDIDOS REALIZADOS: %s\n", this.getTotalDePedidosRealizados());
        System.out.printf("- TOTAL DE PRODUCTOS VENDIDOS: %s\n", this.getTotalDeProductosVendidos());
        System.out.printf("- TOTAL DE CATEGORIAS: %s\n", this.getTotalDeCategorias());
        System.out.printf("- MONTO DE VENTAS: %s\n", NumberFormat.getCurrencyInstance(new Locale("es", "CO")).format(this.montoDeVentas.setScale(2, RoundingMode.HALF_DOWN))); //Pueden cambiar el Locale a la moneda de su pais, siguiendo esta documentación: https://www.oracle.com/java/technologies/javase/java8locales.html

        System.out.printf("- PEDIDO MAS BARATO: %s (%s)\n",
                NumberFormat.getCurrencyInstance
                                (new Locale("es", "Co"))
                        .format(this.pedidoMasBarato.getPrecio())
                        ,pedidoMasBarato.getProducto());

        System.out.printf("- PEDIDO MAS CARO: %s (%s)\n",
                NumberFormat.getCurrencyInstance
                        (new Locale("es", "CO"))
                        .format(this.pedidoMasCaro.getPrecio().multiply(new BigDecimal(this.pedidoMasCaro.getCantidad())).setScale(2, RoundingMode.HALF_DOWN)), this.pedidoMasCaro.getProducto());
    }

    public static int totalDeProductosVendidos(List<Pedido> pedidos) {
        return pedidos.stream()
                .mapToInt(Pedido::getCantidad)
                .sum();
    }

    public static BigDecimal montoDeVentas(List<Pedido> pedidos) {
        return pedidos.stream()
                .map(Pedido::getValorTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    public static int totalDePedidosRealizados(List<Pedido> pedidos) {
        return pedidos.size();
    }

    public static Pedido pedidoMasBarato(List<Pedido> pedidos) {
        return pedidos.stream()
                .min(Comparator.comparing(pedido ->
                        pedido.getPrecio()
                                .multiply(new BigDecimal(pedido.getCantidad()))))
                .orElse(new Pedido());
    }

    public static Pedido pedidoMasCaro(List<Pedido> pedidos) {
        return pedidos.stream()
                .max(Comparator.comparing(pedido ->
                        pedido.getPrecio()
                                .multiply(new BigDecimal(pedido.getCantidad()))))
                .orElse(new Pedido());
    }
    public static List<String> totalDeCategorias(List<Pedido> pedidos) {
        return pedidos.stream()
                .map(Pedido::getCategoria)
                .distinct()
                .toList();
    }
    public int getTotalDePedidosRealizados() {
        return totalDePedidosRealizados;
    }

    public int getTotalDeProductosVendidos() {
        return totalDeProductosVendidos;
    }

    public int getTotalDeCategorias() {
        return totalDeCategorias;
    }

}
