package com.alura.comex.service;

import com.alura.comex.model.Categoria;
import com.alura.comex.model.Pedido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InformeSinteticoCalculadoraServiceTest {

    @InjectMocks
    private InformeSinteticoCalculadoraService service = new InformeSinteticoCalculadoraService();

    @Mock
    List<Pedido> pedidos;

    @Mock
    List<Categoria> categorias;

    @BeforeEach
    void setUp() {

        pedidos = List.of(
                new Pedido("Electrónica", "Laptop", "Cliente1", new BigDecimal("100"), 1, LocalDate.now()),
                new Pedido("Electrónica", "Smartphone", "Cliente2", new BigDecimal("101"), 2,LocalDate.now()),
                new Pedido("Hogar", "Mueble", "Cliente3", new BigDecimal("100"), 3, LocalDate.now()),
                new Pedido("Hogar", "Mesa", "Cliente5", new BigDecimal("100"), 5, LocalDate.now()),
                new Pedido("Hogar", "Silla", "Cliente6", new BigDecimal("100"), 6, LocalDate.now()),
                new Pedido("Hogar", "Cama", "Cliente7", new BigDecimal("101"), 7, LocalDate.now()),
                new Pedido("Libros", "Brain Rules", "Cliente4", new BigDecimal("100"), 4, LocalDate.now())
        );
    }

    @Test
    void calcularTotalVentasCategoria() {
        List<Categoria> categorias = service.calcularTotalVentasCategoria(pedidos);

        assertNotNull(categorias);
        assertEquals(3, categorias.size()); //Se reduce a tres categorias
        assertEquals(302, categorias.get(0).getMontoVendido().intValue()); //Se compara el monto 301 Electronica
        assertEquals(2107, categorias.get(1).getMontoVendido().intValue());//Se compara el monto 2107 Hogar
        assertEquals(400, categorias.get(2).getMontoVendido().intValue());//Se compara el monto 400 Libros
    }

    @Test
    void calcularProductosMasVendidos() {

        List<Pedido> pedidos = service.calcularProductosMasVendidos(this.pedidos);

        assertNotNull(pedidos);
        assertEquals(3, pedidos.size());//Se reduce a tres productos
        assertEquals("Cama", pedidos.get(0).getProducto());//Se verifica que Cama sea el primer producto
        assertEquals("Silla", pedidos.get(1).getProducto());//Se verifica que Silla sea el segundo producto
        assertEquals("Mesa", pedidos.get(2).getProducto());//Se verifica que Mesa sea el tercer producto
    }

    @Test
    void calcularLosProductosMasCarosPorCategoria() {

        List<Pedido> pedidos = service.calcularLosProductosMasCarosPorCategoria(this.pedidos);

        assertNotNull(pedidos);
        assertEquals("Smartphone", pedidos.get(0).getProducto());//Se verifica que Smartphone sea el primer producto
        assertEquals("Cama", pedidos.get(1).getProducto()); //Se verifica que Cama sea el segundo producto
        assertEquals("Brain Rules", pedidos.get(2).getProducto());//Se verifica que Brain Rules sea el tercer producto

    }
}