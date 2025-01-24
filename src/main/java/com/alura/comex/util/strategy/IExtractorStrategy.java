package com.alura.comex.util.strategy;

import com.alura.comex.model.Pedido;

import java.util.ArrayList;

public interface IExtractorStrategy {
    ArrayList<Pedido> extract(String path);
}
