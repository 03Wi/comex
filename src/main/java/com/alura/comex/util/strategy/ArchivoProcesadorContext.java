package com.alura.comex.util.strategy;

import com.alura.comex.model.Pedido;

import java.util.ArrayList;
import java.util.List;

public class ArchivoProcesadorContext {

    private IExtractorStrategy extractor;

    public void setStrategy(IExtractorStrategy extractor) {
        this.extractor = extractor;
    }

    public List<Pedido> procesadorArchivo(String archivo) {
        return extractor.extract(archivo);
    }
}
