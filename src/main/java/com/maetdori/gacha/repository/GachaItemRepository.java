package com.maetdori.gacha.repository;

import com.maetdori.gacha.entity.Gacha;
import com.maetdori.gacha.entity.GachaItem;
import com.maetdori.gacha.enums.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GachaItemRepository extends JpaRepository<GachaItem, Integer> {
    List<GachaItem> findAllByGachaAndGrade(Gacha gacha, Grade grade);
}
