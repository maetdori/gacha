package com.maetdori.gacha.service;

import com.maetdori.gacha.entity.DrawTable;
import com.maetdori.gacha.enums.Price;
import com.maetdori.gacha.repository.DrawTableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DrawTableService {

    private final DrawTableRepository drawTableRepository;

    public List<DrawTable> getDrawTableList(Price price) {
        // 확률이 낮은 순서로 정렬된 데이터
        return drawTableRepository.findAllByPriceOrderByEndRangeDesc(price);
    }

    public int getRange(List<DrawTable> drawTables) {
        if (drawTables.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return drawTables.getFirst().getEndRange() + 1;
    }
}
