package com.alura.comex.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pedido {

    private String categoria;
    private String producto;
    private String cliente;
    private BigDecimal precio;
    private int cantidad;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate fecha;

    public Pedido(String categoria, String producto, String cliente, BigDecimal precio, int cantidad, LocalDate fecha) {
        this.categoria = categoria;
        this.producto = producto;
        this.cliente = cliente;
        this.precio = precio;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public Pedido() {

    }

    public String getCliente() {
        return cliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getProducto() {
        return producto;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }


    @Override
    public String toString() {
        return "Pedido{" +
                "categoria='" + categoria + '\'' +
                ", producto='" + producto + '\'' +
                ", cliente='" + cliente + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                ", fecha=" + fecha +
                '}';
    }

    public BigDecimal getValorTotal(){
        return this.getPrecio()
                .multiply(new BigDecimal(this.getCantidad()));
    }

}
