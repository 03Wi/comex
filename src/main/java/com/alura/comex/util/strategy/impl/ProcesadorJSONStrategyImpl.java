package com.alura.comex.util.strategy.impl;

import com.alura.comex.model.Pedido;
import com.alura.comex.util.strategy.IExtractorStrategy;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

public class ProcesadorJSONStrategyImpl implements IExtractorStrategy {

    @Override
    public List<Pedido> extract(String path) {

        try {
            File file = getFileOfSystem(path);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            return objectMapper.readValue(file, new TypeReference<List<Pedido>>() {});
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static File getFileOfSystem(String path) throws URISyntaxException {
        URL recurso = ClassLoader.getSystemResource(path);
        return new File(recurso.toURI());
    }

}
