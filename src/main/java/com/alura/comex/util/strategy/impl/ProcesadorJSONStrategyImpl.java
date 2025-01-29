package com.alura.comex.util.strategy.impl;

import com.alura.comex.model.Pedido;
import com.alura.comex.util.strategy.IExtractorStrategy;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
//import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.net.URL;
import java.util.List;

public class ProcesadorJSONStrategyImpl implements IExtractorStrategy {

    @Override
    public List<Pedido> extract(String path) {

        try {
            URL recurso = ClassLoader.getSystemResource(path);
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(recurso.toURI());
//            System.out.println(objectMapper.readTree(file).toString());
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return objectMapper.readValue(file, new TypeReference<List<Pedido>>() {});
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
