package com.maetdori.gacha.controller;

import com.maetdori.gacha.dto.GachaItemDto;
import com.maetdori.gacha.service.DrawService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/draw")
@RestController
public class DrawController {

    private final DrawService drawService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{gachaId}")
    public GachaItemDto getGachaItem(@PathVariable("gachaId") Integer gachaId,
                                     @RequestParam("coinCount") Integer coinCount) {
        System.out.println("gachaId: " + gachaId + ", coinCount: " + coinCount);
        return drawService.getGachaItem(gachaId, coinCount);
    }
}
