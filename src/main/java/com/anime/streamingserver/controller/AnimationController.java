package com.anime.streamingserver.controller;


import com.anime.streamingserver.dto.anime.NewAnimeListDto;
import com.anime.streamingserver.service.anime.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnimationController {

    @Autowired
    AnimeService animeService;

    @GetMapping("/anime/recent")
    public NewAnimeListDto getNewAnimation() {
        return animeService.getNewAnimation();
    }

    @GetMapping("/anime/{id}")
    public String getAnimation(@PathVariable Long id) {
        return "getAnimation";
    }

    @PostMapping("/anime/add")
    public String addAnimation() {
        return "addAnimation";
    }
}
