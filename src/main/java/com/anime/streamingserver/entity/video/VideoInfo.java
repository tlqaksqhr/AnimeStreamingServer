package com.anime.streamingserver.entity.video;


import com.anime.streamingserver.entity.anime.Animation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class VideoInfo {

    @Id @GeneratedValue
    @Column(name = "video_info_id")
    private Long id;

    private String title;
    private String desc;

    @Column(name = "video_url")
    private String videoUrl;

    @Column(name = "video_type")
    @Enumerated(EnumType.STRING)
    private VideoType videoType;

    @Column(name = "access_level")
    @Enumerated(EnumType.STRING)
    private AccessLevel accessLevel;

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
