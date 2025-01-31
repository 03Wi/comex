package com.alura.comex.model;

import java.math.BigDecimal;

public class Categoria {

    private String name;
    private int cantidadProductosVendidos;
    private BigDecimal montoVendido;

    public Categoria(String name, int cantidadProductosVendidos, BigDecimal montoVendido) {
        this.name = name;
        this.cantidadProductosVendidos = cantidadProductosVendidos;
        this.montoVendido = montoVendido;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCantidadProductosVendidos() {
        return cantidadProductosVendidos;
    }

    public void setCantidadProductosVendidos(int cantidadProductosVendidos) {
        this.cantidadProductosVendidos = cantidadProductosVendidos;
    }

    public BigDecimal getMontoVendido() {
        return montoVendido;
    }

    public void setMontoVendido(BigDecimal montoVendido) {
        this.montoVendido = montoVendido;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "name='" + name + '\'' +
                ", cantidadProductosVendidos=" + cantidadProductosVendidos +
                ", montoVendido=" + montoVendido +
                '}';
    }
}
