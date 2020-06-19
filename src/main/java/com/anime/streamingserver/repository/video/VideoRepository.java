package com.anime.streamingserver.repository.video;


import com.anime.streamingserver.entity.anime.Animation;
import com.anime.streamingserver.entity.video.VideoInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface VideoRepository extends JpaRepository<VideoInfo, Long> {

    @Query("SELECT v FROM Video v WHERE animation_id = :animationID")
    List<VideoInfo> findAllVideoByAnimationID(Long animationID);
}
