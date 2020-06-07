package com.anime.streamingserver.entity.anime;

import com.anime.streamingserver.entity.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Rating {

    @Id @GeneratedValue
    @Column(name = "rating_id")
    private Long id;
    //private User user;
    private double rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animation_id")
    private Animation animation;
}
