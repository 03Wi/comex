package com.alura.comex.util.factory;

import com.alura.comex.util.strategy.IExtractorStrategy;
import com.alura.comex.util.strategy.impl.ProcesadorCSVStrategyImpl;
import com.alura.comex.util.strategy.impl.ProcesadorJSONStrategyImpl;
import com.alura.comex.util.strategy.impl.ProcesadorXMLStrategyImpl;

public class ArchivoFactory {

    public static IExtractorStrategy getStrategy(String path) {
        String end = path.substring(path.lastIndexOf("."));
        switch (end){
            case ".json" -> {
                return new ProcesadorJSONStrategyImpl();
            }
            case ".xml" -> {
                return new ProcesadorXMLStrategyImpl();
            }
            case ".csv" -> {
                return new ProcesadorCSVStrategyImpl();
            }
            default ->
                    throw new IllegalArgumentException("Formato de archivo no soportado");
        }
    }
}
