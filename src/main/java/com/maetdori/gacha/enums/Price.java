package com.maetdori.gacha.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum Price {
    COIN1(1), COIN3(3), COIN5(5);

    private final int coinCount;

    public static Price ofCoinCount(int coinCount) {
        return Arrays.stream(values())
                .filter(price -> price.coinCount == coinCount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("정의되지 않은 가격 정책"));
    }
}
