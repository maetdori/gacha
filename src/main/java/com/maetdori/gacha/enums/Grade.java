package com.maetdori.gacha.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum Grade {
    GRADE5(5), GRADE4(4), GRADE3(3), GRADE2(2), GRADE1(1);

    private final int star;
}
