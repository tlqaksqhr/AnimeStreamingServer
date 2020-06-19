package com.anime.streamingserver.dto.anime;

import com.anime.streamingserver.entity.anime.GenreCategory;
import com.anime.streamingserver.entity.anime.TagCategory;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AnimeDto {

    private Long id;
    private String title;
    private String content;
    private String makeInfo;
    private int age;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String thumbnail;

    private List<GenreCategory> genreCategories = new ArrayList<GenreCategory>();

    private List<TagCategory> tagCategories = new ArrayList<TagCategory>();
}
