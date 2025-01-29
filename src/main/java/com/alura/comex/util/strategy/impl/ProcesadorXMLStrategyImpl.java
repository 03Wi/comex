package com.alura.comex.util.strategy.impl;

import com.alura.comex.model.ListaPedidos;
import com.alura.comex.model.Pedido;
import com.alura.comex.util.strategy.IExtractorStrategy;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.net.URL;
import java.util.List;

public class ProcesadorXMLStrategyImpl implements IExtractorStrategy {

    @Override
    public List<Pedido> extract(String path) {

        try {
            URL recurso = ClassLoader.getSystemResource(path);
            File file = new File(recurso.toURI());
            XmlMapper mapper = new XmlMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(file, ListaPedidos.class).getPedidos();

        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
