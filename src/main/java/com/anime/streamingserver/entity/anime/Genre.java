package com.anime.streamingserver.entity.anime;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


// TODO : 나중에 다대다 관계로 바꿔야 함..

@Entity
@SequenceGenerator(
        name = "GENRE_SEQ_GENERATOR",
        sequenceName = "GENRE_SEQ",
        initialValue = 1, allocationSize = 100)
@Getter
@Setter
@NoArgsConstructor
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GENRE_SEQ_GENERATOR")
    @Column(name = "genre_id")
    private Long id;
    private String genre;

    @OneToMany(mappedBy = "genre")
    private List<GenreCategory> genreCategories = new ArrayList<GenreCategory>();
}
