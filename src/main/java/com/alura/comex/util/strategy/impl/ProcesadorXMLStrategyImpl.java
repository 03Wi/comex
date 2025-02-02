package com.alura.comex.util.strategy.impl;

import com.alura.comex.model.ListaPedidos;
import com.alura.comex.model.Pedido;
import com.alura.comex.util.strategy.IExtractorStrategy;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

public class ProcesadorXMLStrategyImpl implements IExtractorStrategy {

    @Override
    public List<Pedido> extract(String path) {

        try {
            File file = getFileOfSystem(path);
            XmlMapper mapper = new XmlMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(file, ListaPedidos.class).getPedidos();

        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static File getFileOfSystem(String path) throws URISyntaxException {
        URL recurso = ClassLoader.getSystemResource(path);
        return new File(recurso.toURI());
    }
}
