package com.maetdori.gacha.enums.converter;

import com.maetdori.gacha.enums.Grade;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class GradePersistConverter implements AttributeConverter<Grade, String> {

    @Override
    public String convertToDatabaseColumn(Grade grade) {
        return grade.name();
    }

    @Override
    public Grade convertToEntityAttribute(String gradeName) {
        return Grade.valueOf(gradeName);
    }
}
