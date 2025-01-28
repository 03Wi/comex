package com.alura.comex.util.strategy;

import com.alura.comex.model.Pedido;

import java.util.ArrayList;
import java.util.List;

public interface IExtractorStrategy {
    List<Pedido> extract(String path);
}
