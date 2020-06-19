package com.anime.streamingserver.entity.anime;

import com.anime.streamingserver.entity.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Rating {

    @Id @GeneratedValue
    @Column(name = "rating_id")
    private Long id;

    private double rating;

    //@CreatedBy
    //@Column(updatable = false)
    //private String createdBy;

    //@LastModifiedBy
    //private String lastModifiedBy;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createTime;

    @LastModifiedDate
    private LocalDateTime updateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animation_id")
    private Animation animation;
}
