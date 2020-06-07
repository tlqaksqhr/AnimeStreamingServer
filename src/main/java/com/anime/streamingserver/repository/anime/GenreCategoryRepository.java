package com.anime.streamingserver.repository.anime;


import com.anime.streamingserver.entity.anime.GenreCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreCategoryRepository extends JpaRepository<GenreCategory, Long> {
}
