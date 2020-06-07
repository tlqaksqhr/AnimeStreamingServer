package com.anime.streamingserver.entity.anime;


import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class GenreCategory {

    @Id
    @GeneratedValue
    @Column(name = "genre_category_id")
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animation_id")
    private Animation animation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    private Genre genre;
}
