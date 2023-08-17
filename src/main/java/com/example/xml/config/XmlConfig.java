package com.example.xml.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class XmlConfig {

    @Bean
    public XmlMapper xmlMapper(){
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
//        xmlMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES,false);
        return new XmlMapper();
    }
}
