package com.alura.comex.util.informe;

import com.alura.comex.model.InformeSintetico;
import com.alura.comex.service.InformeSinteticoCalculadoraService;
import com.alura.comex.model.Pedido;

import java.util.List;

public class CrearInformeSintetico {

    private InformeSinteticoCalculadoraService calculadora;

    public CrearInformeSintetico(InformeSinteticoCalculadoraService calculadora) {
        this.calculadora = calculadora;
    }

    public InformeSintetico generarInformeSintetico(List<Pedido> pedidos) {

        return new InformeSintetico(
                calculadora.calcularTotalDePedidosRealizados(pedidos),
                calculadora.calcularTotalDeProductosVendidos(pedidos),
                calculadora.calcularTotalDeCategorias(pedidos).size(),
                calculadora.calcularMontoDeVentas(pedidos),
                calculadora.calcularPedidoMasBarato(pedidos),
                calculadora.calcularPedidoMasCaro(pedidos));

    }


}
