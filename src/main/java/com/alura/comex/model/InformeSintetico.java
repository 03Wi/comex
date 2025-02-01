package com.alura.comex.model;

import java.math.BigDecimal;
import java.util.List;

public class InformeSintetico {

    private int totalDePedidosRealizados;
    private int totalDeProductosVendidos;
    private int totalDeCategorias;
    private BigDecimal montoDeVentas;
    private Pedido pedidoMasBarato;
    private Pedido pedidoMasCaro;
    private List<Categoria> totalVentasCategoria;
    private List<Pedido> productosMasVendidos;
    private List<Pedido> productosMasCarosCategoria;

    public InformeSintetico(int totalDePedidosRealizados,
                            int totalDeProductosVendidos,
                            int totalDeCategorias,
                            BigDecimal montoDeVentas,
                            Pedido pedidoMasBarato,
                            Pedido pedidoMasCaro,
                            List<Categoria> totalVentasCategoria,
                            List<Pedido> productosMasVendidos,
                            List<Pedido> productosMasCarosCategoria) {

        this.totalDePedidosRealizados = totalDePedidosRealizados;
        this.totalDeProductosVendidos = totalDeProductosVendidos;
        this.totalDeCategorias = totalDeCategorias;
        this.montoDeVentas = montoDeVentas;
        this.pedidoMasBarato = pedidoMasBarato;
        this.pedidoMasCaro = pedidoMasCaro;
        this.totalVentasCategoria = totalVentasCategoria;
        this.productosMasVendidos = productosMasVendidos;
        this.productosMasCarosCategoria = productosMasCarosCategoria;
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

    public List<Categoria> getTotalVentasCategoria() {
        return totalVentasCategoria;
    }

    public List<Pedido> getProductosMasVendidos() {
        return productosMasVendidos;
    }

    public List<Pedido> getProductosMasCarosCategoria() {
        return productosMasCarosCategoria;
    }

    public BigDecimal calcularPrecioPedidoMasCaro(Pedido pedido) {
        return pedido.getPrecio().multiply(new BigDecimal(pedido.getCantidad()));
    }

}
