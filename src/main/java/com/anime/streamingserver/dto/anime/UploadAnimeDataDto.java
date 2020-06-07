package com.anime.streamingserver.dto.anime;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class UploadAnimeDataDto {

    private String title;
    private String content;
    private String makeInfo;
    private int age;

    private String thumbnail;

    List<String> genres;
    List<String> tags;
}
