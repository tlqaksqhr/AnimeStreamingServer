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
    private List<GenreCategory> genreCategorys = new ArrayList<GenreCategory>();
}
