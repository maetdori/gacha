package com.maetdori.gacha.service;

import com.maetdori.gacha.entity.Gacha;
import com.maetdori.gacha.entity.GachaItem;
import com.maetdori.gacha.enums.Grade;
import com.maetdori.gacha.repository.GachaItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GachaItemService {

    private final GachaItemRepository gachaItemRepository;

    public List<GachaItem> getGachaItemListByGachaAndGrade(Gacha gacha, Grade grade) {
        return gachaItemRepository.findAllByGachaAndGrade(gacha, grade);
    }
}
