package com.anime.streamingserver.dto.anime;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class NewAnimeDto {

    private Long id;
    private String title;
    private String desc;

    public NewAnimeDto(Long id, String title, String desc) {
        this.id = id;
        this.title = title;
        this.desc = desc;
    }
}
