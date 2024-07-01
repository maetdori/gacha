package com.maetdori.gacha.entity.embed;

import com.maetdori.gacha.enums.Grade;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class GradeCount {

    private Grade grade;
    private Integer count;
}
