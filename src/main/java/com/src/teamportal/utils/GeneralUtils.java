package com.src.teamportal.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class GeneralUtils {


    @Autowired
    private  ObjectMapper objectMapper;

    public Object commonUpdate(Object updationValue,Object valueTobeUpdated) throws IOException {
        ObjectReader d;

        return objectMapper.readerForUpdating(valueTobeUpdated).readValue(toJsonString(updationValue));

    }

    private String toJsonString(Object data) throws JsonProcessingException {
        return objectMapper.writeValueAsString(data);
    }
}
