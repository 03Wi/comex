package com.alura.comex;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pedido {

    private String categoria;
    private String producto;
    private String cliente;

    private BigDecimal precio;
    private int cantidad;

    private LocalDate fecha;

    public Pedido(String categoria, String producto, String cliente, BigDecimal precio, int cantidad, LocalDate fecha) {
        this.categoria = categoria;
        this.producto = producto;
        this.cliente = cliente;
        this.precio = precio;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getProducto() {
        return producto;
    }

    public String getCliente() {
        return cliente;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public LocalDate getFecha() {
        return fecha;
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

    public boolean isMasBaratoQue(Pedido pedido){

        return this.getPrecio()
                .multiply(new BigDecimal(this.getCantidad()))
                .compareTo(
                        pedido.getPrecio()
                                .multiply( new BigDecimal(pedido.getCantidad())) ) < 0;
    }

    public boolean isMasCaroQue(Pedido pedido){

        return !this.isMasBaratoQue(pedido);
//        return this
//                .getPrecio()
//                .multiply(new BigDecimal(this.getCantidad()))
//                .compareTo(
//                        pedido.getPrecio()
//                        .multiply(new BigDecimal( pedido.getCantidad())) ) > 0;
    }

}
