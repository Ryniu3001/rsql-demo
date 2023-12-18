package com.example.rsqldemo.business;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
class BicConverter implements AttributeConverter<Bic, String> {
    @Override
    public String convertToDatabaseColumn(Bic attribute) {
        return attribute.getValue();
    }

    @Override
    public Bic convertToEntityAttribute(String dbData) {
        return Bic.of(dbData);
    }
}
