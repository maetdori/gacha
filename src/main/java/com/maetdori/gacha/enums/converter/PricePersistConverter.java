package com.maetdori.gacha.enums.converter;

import com.maetdori.gacha.enums.Price;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PricePersistConverter implements AttributeConverter<Price, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Price price) {
        return price.getCoinCount();
    }

    @Override
    public Price convertToEntityAttribute(Integer coinCount) {
        return Price.ofCoinCount(coinCount);
    }
}
