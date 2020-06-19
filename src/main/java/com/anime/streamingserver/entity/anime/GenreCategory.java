package com.anime.streamingserver.entity.anime;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@SequenceGenerator(
        name = "GENRE_CATEGORY_SEQ_GENERATOR",
        sequenceName = "GENRE_CATEGORY_SEQ",
        initialValue = 1, allocationSize = 100)
@Getter
@Setter
public class GenreCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GENRE_CATEGORY_SEQ_GENERATOR")
    @Column(name = "genre_category_id")
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animation_id")
    private Animation animation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    private Genre genre;
}
