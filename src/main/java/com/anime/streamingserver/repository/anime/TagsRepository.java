package com.anime.streamingserver.repository.anime;

import com.anime.streamingserver.entity.anime.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TagsRepository extends JpaRepository<Tags, Long> {
}
