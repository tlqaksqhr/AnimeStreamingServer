package com.anime.streamingserver.repository.anime;

import com.anime.streamingserver.entity.anime.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

}
