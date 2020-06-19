package com.anime.streamingserver.dto.video;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UploadVideoDataDto {
    private String title;
    private String desc;

    private String videoUrl;

    private String videoType;

    private String accessLevel;

    private int episodeNumber;

    private int episodeOrder;

    private int animationID;
}
