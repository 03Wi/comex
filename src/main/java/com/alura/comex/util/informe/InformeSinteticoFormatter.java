package com.alura.comex.util.informe;

import com.alura.comex.model.InformeSintetico;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public class InformeSinteticoFormatter {

    public static void formatter(InformeSintetico informe) {

        System.out.println("#### INFORME DE VALORES TOTALES");
        System.out.printf("- TOTAL DE PEDIDOS REALIZADOS: %s\n", informe.getTotalDePedidosRealizados());
        System.out.printf("- TOTAL DE PRODUCTOS VENDIDOS: %s\n", informe.getTotalDeProductosVendidos());
        System.out.printf("- TOTAL DE CATEGORIAS: %s\n", informe.getTotalDeCategorias());
        System.out.printf("- MONTO DE VENTAS: %s\n",
                NumberFormat.getCurrencyInstance(new Locale("es", "CO"))
                        .format(informe.getMontoDeVentas().setScale(2, RoundingMode.HALF_DOWN))); //Pueden cambiar el Locale a la moneda de su pais, siguiendo esta documentación: https://www.oracle.com/java/technologies/javase/java8locales.html
        System.out.printf("- PEDIDO MAS BARATO: %s (%s)\n",
                NumberFormat.getCurrencyInstance(new Locale("es", "Co"))
                        .format(informe.getPedidoMasBarato().getPrecio())
                , informe.getPedidoMasBarato().getProducto());

        System.out.printf("- PEDIDO MAS CARO: %s (%s)\n\n",
                NumberFormat.getCurrencyInstance(new Locale("es", "CO"))
                        .format(informe.calcularPrecioPedidoMasCaro(informe.getPedidoMasCaro())),
                informe.getPedidoMasCaro().getProducto());

        System.out.println("#### INFORME DE PRODUCTOS MAS VENDIDOS");
        informe.getProductosMasVendidos().forEach(pedido -> {
            System.out.printf("- Producto: %s, Unidades: %s\n",
                    pedido.getProducto(),
                    pedido.getCantidad());
        });

        System.out.println("\n#### INFORME DE VENTAS POR CATEGORIAS");
        informe.getTotalVentasCategoria().forEach(categoria -> {
            System.out.printf("- Categoria: %s: Unidades: %s, Monto: %s\n",
                    categoria.getName(),
                    categoria.getCantidadProductosVendidos(),
                    NumberFormat.getCurrencyInstance(new Locale("es", "CO"))
                            .format(categoria.getMontoVendido().setScale(2, RoundingMode.HALF_DOWN)));
        });
        System.out.println("\n#### INFORME DE PRODUCTOS MAS CAROS DE CADA CATEGORIA");
        informe.getProductosMasCarosCategoria().forEach(pedido -> {
            System.out.printf("- Categoria: %s: Producto: %s, Precio: %s)\n",
                    pedido.getCategoria(),
                    pedido.getProducto(),
                    NumberFormat.getCurrencyInstance(new Locale("es", "CO"))
                            .format(pedido.getPrecio().setScale(2, RoundingMode.HALF_DOWN)));
        });
    }
}
