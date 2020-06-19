package com.anime.streamingserver.entity.anime;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@SequenceGenerator(
        name = "TAG_CATEGORY_SEQ_GENERATOR",
        sequenceName = "TAG_CATEGORY_SEQ",
        initialValue = 1, allocationSize = 100)
@Getter
@Setter
public class TagCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TAG_CATEGORY_SEQ_GENERATOR")
    @Column(name = "tag_category_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animation_id")
    private Animation animation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    private Tag tag;
}
