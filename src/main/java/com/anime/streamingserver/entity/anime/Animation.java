package com.anime.streamingserver.entity.anime;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// TODO : 나중에 판권만료 Entity 도 추가
// TODO : 상속형태로 바꾸기

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EntityListeners(AuditingEntityListener.class)
public class Animation {

    @Id @GeneratedValue
    @Column(name = "animation_id")
    private Long id;
    private String title;
    private String content;
    private String makeInfo;
    private int age;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createTime;

    @LastModifiedDate
    private LocalDateTime updateTime;

    private String thumbnail;

    @OneToMany(mappedBy = "animation")
    private List<GenreCategory> genreCategories = new ArrayList<GenreCategory>();

    @OneToMany(mappedBy = "tag")
    private List<TagCategory> tagCategories = new ArrayList<TagCategory>();
}
