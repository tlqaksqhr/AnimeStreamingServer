package com.anime.streamingserver.entity.video;


import com.anime.streamingserver.entity.anime.Animation;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class VideoInfo {

    @Id @GeneratedValue
    @Column(name = "video_info_id")
    private Long id;

    private String title;
    private String desc;

    @Column(name = "video_url")
    private String videoUrl;

    // TODO : enum type 으로 바꾸기
    @Column(name = "video_type")
    private String videoType;

    // TODO : enum type 으로 바꾸기
    @Column(name = "access_level")
    private String accessLevel;

    @CreatedDate
    private LocalDateTime publishDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    @Column(name = "episode_number")
    private int episodeNumber;

    @Column(name = "episode_order")
    private int episodeOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animation_id")
    private Animation animation;
}
