package com.alura.comex.util.strategy;

import com.alura.comex.model.Pedido;

import java.util.ArrayList;

public class ArchivoProcesadorContext {

    private IExtractorStrategy extractor;

    public void setStrategy(IExtractorStrategy extractor) {
        this.extractor = extractor;
    }

    public ArrayList<Pedido> procesadorArchivo(String archivo) {
        return extractor.extract(archivo);
    }
}
