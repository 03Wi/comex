package com.alura.comex.util;

import com.alura.comex.Pedido;

import java.util.ArrayList;

public interface IFileExtractor {

    ArrayList<Pedido> extract(String path);
}
