package com.anime.streamingserver.entity.anime;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@SequenceGenerator(
        name = "TAG_SEQ_GENERATOR",
        sequenceName = "TAG_SEQ",
        initialValue = 1, allocationSize = 100)
@Getter
@Setter
@NoArgsConstructor
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TAG_SEQ_GENERATOR")
    @Column(name = "tag_id")
    private Long id;
    private String tag;

    @OneToMany(mappedBy = "tag")
    List<TagCategory> tagCategories = new ArrayList<TagCategory>();
}
