package com.maetdori.gacha.entity;

import com.maetdori.gacha.enums.Grade;
import com.maetdori.gacha.enums.Price;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@Schema(description = "코인 개수 별 / 등급 별 뽑기 확률 매핑 테이블")
@NoArgsConstructor (access = AccessLevel.PROTECTED)
@Entity
public class DrawTable {

    @Id
    @Column(name = "draw_table_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Schema(description = "코인 개수")
    private Price price;

    @Schema(description = "등급")
    private Grade grade;

    @Schema(description = "확률(%)")
    private BigDecimal probability;

    @Schema(description = "확률에 따라 정의된 정수 범위의 시작 값")
    private Integer startRange;

    @Schema(description = "확률에 따라 정의된 정수 범위의 마지막 값")
    private Integer endRange;
}
