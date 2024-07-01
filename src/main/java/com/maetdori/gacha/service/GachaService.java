package com.maetdori.gacha.service;

import com.maetdori.gacha.entity.Gacha;
import com.maetdori.gacha.repository.GachaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GachaService {

    private final GachaRepository gachaRepository;

    public List<Gacha> getGachaList() {
        return gachaRepository.findAll();
    }

    public Gacha getGacha(Integer gachaId) {
        return gachaRepository.findById(gachaId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 가챠"));
    }
}
