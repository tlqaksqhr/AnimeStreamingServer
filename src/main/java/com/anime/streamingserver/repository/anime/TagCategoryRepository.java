package com.anime.streamingserver.repository.anime;


import com.anime.streamingserver.entity.anime.TagCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagCategoryRepository extends JpaRepository<TagCategory, Long> {
}
