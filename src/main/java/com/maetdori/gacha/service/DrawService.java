package com.maetdori.gacha.service;

import com.maetdori.gacha.dto.GachaItemDto;
import com.maetdori.gacha.entity.DrawTable;
import com.maetdori.gacha.entity.Gacha;
import com.maetdori.gacha.entity.GachaItem;
import com.maetdori.gacha.enums.Grade;
import com.maetdori.gacha.enums.Price;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class DrawService {

    private final GachaService gachaService;
    private final GachaItemService gachaItemService;
    private final DrawTableService drawTableService;

    public GachaItemDto getGachaItem(Integer gachaId, Integer coinCount) {
        Gacha gacha = gachaService.getGacha(gachaId);
        Price price = Price.ofCoinCount(coinCount);

        // 등급 뽑기
        Grade grade = drawItemGrade(price);
        // 해당 등급의 아이템 뽑기
        GachaItem gachaItem = getRandomItemOf(gacha, grade);

        return GachaItemDto.from(gachaItem);
    }

    /**
     * 등급 뽑기
     * @param price 투자한 코인 개수
     * @return 당첨된 등급
     */
    private Grade drawItemGrade(Price price) {
        List<DrawTable> drawTables = drawTableService.getDrawTableList(price);
        int range = drawTableService.getRange(drawTables);
        int randomNumber = getRandomNumber(range);

        return getItemGradeOfRandomNumber(drawTables, randomNumber);
    }

    private int getRandomNumber(int range) {
        return new SecureRandom().nextInt(range); // 0 이상 range 미만 범위의 랜덤 정수
    }

    private Grade getItemGradeOfRandomNumber(List<DrawTable> drawTables, int randomNumber) {
        for (DrawTable table : drawTables) {
            if (table.getStartRange() <= randomNumber && randomNumber <= table.getEndRange()) {
                return table.getGrade();
            }
        }

        throw new IllegalArgumentException();
    }

    /**
     * 해당 등급의 아이템 뽑기
     * @param gacha 가챠 머신
     * @param grade 등급
     * @return 랜덤 가챠 아이템
     */
    private GachaItem getRandomItemOf(Gacha gacha, Grade grade) {
        List<GachaItem> gachaItemList = gachaItemService.getGachaItemListByGachaAndGrade(gacha, grade);

        if (gachaItemList.isEmpty()) {
            throw new NoSuchElementException("선택한 가챠에 해당 등급의 아이템이 없습니다.");
        }

        Collections.shuffle(gachaItemList);
        return gachaItemList.getFirst();
    }
}
