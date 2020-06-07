package com.anime.streamingserver.entity.anime;


import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Following {

    @Id @GeneratedValue
    @Column(name = "following_id")
    private Long id;
}
