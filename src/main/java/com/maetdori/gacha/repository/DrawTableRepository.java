package com.maetdori.gacha.repository;

import com.maetdori.gacha.entity.DrawTable;
import com.maetdori.gacha.enums.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrawTableRepository extends JpaRepository<DrawTable, Integer> {
    List<DrawTable> findAllByPriceOrderByEndRangeDesc(Price price);
}
