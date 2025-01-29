package com.alura.comex.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.List;


public class ListaPedidos {

    @JacksonXmlCData
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Pedido> pedido;

    public ListaPedidos() {
    }

    public ListaPedidos(List<Pedido> pedidos) {
        this.pedido = pedidos;
    }

    public List<Pedido> getPedidos() {
        return pedido;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedido = pedidos;
    }

    @Override
    public String toString() {
        return "ListaPedidos{" +
                "pedido=" + pedido +
                '}';
    }
}
