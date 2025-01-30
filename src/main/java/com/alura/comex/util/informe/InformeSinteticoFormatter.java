package com.alura.comex.util.informe;

import com.alura.comex.model.InformeSintetico;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public class InformeSinteticoFormatter {

    public static void show(InformeSintetico informe) {

        System.out.println("#### INFORME DE VALORES TOTALES");
        System.out.printf("- TOTAL DE PEDIDOS REALIZADOS: %s\n", informe.getTotalDePedidosRealizados());
        System.out.printf("- TOTAL DE PRODUCTOS VENDIDOS: %s\n", informe.getTotalDeProductosVendidos());
        System.out.printf("- TOTAL DE CATEGORIAS: %s\n", informe.getTotalDeCategorias());
        System.out.printf("- MONTO DE VENTAS: %s\n",
                NumberFormat.getCurrencyInstance
                                (new Locale("es", "CO"))
                        .format(informe.getMontoDeVentas().setScale(2, RoundingMode.HALF_DOWN))); //Pueden cambiar el Locale a la moneda de su pais, siguiendo esta documentación: https://www.oracle.com/java/technologies/javase/java8locales.html

        System.out.printf("- PEDIDO MAS BARATO: %s (%s)\n",
                NumberFormat.getCurrencyInstance
                                (new Locale("es", "Co"))
                        .format(informe.getPedidoMasBarato().getPrecio())
                , informe.getPedidoMasBarato().getProducto());
        System.out.println("informe sout = " + informe.getPedidoMasCaro());
        System.out.printf("- PEDIDO MAS CARO: %s (%s)\n",
                NumberFormat.getCurrencyInstance
                                (new Locale("es", "CO"))
                        .format(informe.getPedidoMasCaro().getPrecio()
                                .multiply(new BigDecimal(informe.getPedidoMasCaro().getCantidad()))
                                .setScale(2, RoundingMode.HALF_DOWN)), informe.getPedidoMasCaro().getProducto());

    System.out.printf("- PEDIDO MAS CARO: %s (%s)\n",
                NumberFormat.getCurrencyInstance
                                (new Locale("es", "CO"))
                        .format(informe.getPedidoMasCaro().getPrecio()), informe.getPedidoMasCaro().getProducto());
    }
}
