package com.example.rsqldemo.business;

import io.github.perplexhub.rsql.RSQLCommonSupport;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RsqlConverterConfig {

    @PostConstruct
    void configure() {
        RSQLCommonSupport.addConverter(Bic.class, Bic::of);
    }
}
