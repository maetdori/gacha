package com.maetdori.gacha.entity;

import com.maetdori.gacha.entity.embed.GradeCount;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Gacha {

    @Id
    @Column(name = "gacha_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Schema(description = "가챠 이름")
    private String name;

    @Schema(description = "등급 별 아이템 개수")
    @ElementCollection
    @CollectionTable(name = "gacha_item_cnt", joinColumns = @JoinColumn(name = "gacha_id"))
    private List<GradeCount> gradeCountList = new ArrayList<>();

    @Schema(description = "이미지 URL")
    private String imgUrl;
}
