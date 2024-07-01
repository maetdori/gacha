package com.maetdori.gacha.dto;

import com.maetdori.gacha.entity.GachaItem;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PRIVATE, builderMethodName = "of")
public class GachaItemDto {

    private Integer id;
    private String name;
    private Integer star;
    private String imgUrl;

    public static GachaItemDto from(GachaItem gachaItem) {
        return GachaItemDto.of()
                .id(gachaItem.getId())
                .name(gachaItem.getName())
                .star(gachaItem.getGrade().getStar())
                .imgUrl(gachaItem.getImgUrl())
                .build();
    }
}
