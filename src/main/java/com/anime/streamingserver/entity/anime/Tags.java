package com.anime.streamingserver.entity.anime;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


// TODO : 나중에 다대다 관계로 바꿔야 함..

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Tags {

    @Id @GeneratedValue
    @Column(name = "tag_id")
    private Long id;
    private String tag;
}
