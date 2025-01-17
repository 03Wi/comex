package com.alura.comex;

import java.math.BigDecimal;

public class InformeSintetico {

    private int totalDePedidosRealizados;
    private int totalDeProductosVendidos;
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

    public int getTotalDePedidosRealizados() {
        return totalDePedidosRealizados;
    }

    public int getTotalDeProductosVendidos() {
        return totalDeProductosVendidos;
    }

    public int getTotalDeCategorias() {
        return totalDeCategorias;
    }

    public BigDecimal getMontoDeVentas() {
        return montoDeVentas;
    }

    public Pedido getPedidoMasBarato() {
        return pedidoMasBarato;
    }

    public Pedido getPedidoMasCaro() {
        return pedidoMasCaro;
    }
}
