package com.maetdori.gacha.entity;

import com.maetdori.gacha.enums.Grade;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class GachaItem {

    @Id
    @Column(name = "gacha_item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "gacha_id")
    private Gacha gacha;

    @Schema(description = "아이템 이름")
    private String name;

    @Schema(description = "아이템 등급")
    private Grade grade;

    @Schema(description = "아이템 이미지 URL")
    private String imgUrl;
}
