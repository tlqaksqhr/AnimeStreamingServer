package com.anime.streamingserver.repository.anime;

import com.anime.streamingserver.entity.anime.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
}
