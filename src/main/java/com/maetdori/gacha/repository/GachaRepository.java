package com.maetdori.gacha.repository;

import com.maetdori.gacha.entity.Gacha;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GachaRepository extends JpaRepository<Gacha, Integer> {
}
