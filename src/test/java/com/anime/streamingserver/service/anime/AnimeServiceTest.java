package com.anime.streamingserver.service.anime;


import com.anime.streamingserver.dto.anime.AnimeDto;
import com.anime.streamingserver.dto.anime.UploadAnimeDataDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
public class AnimeServiceTest {

    @Autowired
    AnimeService animeService;

    @Test
    public void addAnimationTest() {

        UploadAnimeDataDto uploadAnimeDataDto = new UploadAnimeDataDto();
        uploadAnimeDataDto.setTitle("카구야님은 연애하고 싶어");
        uploadAnimeDataDto.setContent("카구야님은 연애하고 싶어");
        uploadAnimeDataDto.setThumbnail("Thumbnail11");
        uploadAnimeDataDto.setMakeInfo("제작사 : 쿄애니");
        uploadAnimeDataDto.setAge(15);


        List<String> tags = new ArrayList<String>();
        List<String> genres = new ArrayList<String>();

        tags.add("#연애");
        tags.add("#개그");
        tags.add("#로맨틱");
        tags.add("#쿄애니");
        tags.add("#만화원작");
        tags.add("#2기도 있음");

        genres.add("로맨틱/연애");
        genres.add("개그");
        genres.add("애니");

        uploadAnimeDataDto.setGenres(genres);
        uploadAnimeDataDto.setTags(tags);

        animeService.addAnimation(uploadAnimeDataDto);

        AnimeDto animeDto = animeService.getAnimationById(1L);
    }
}
