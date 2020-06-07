package com.anime.streamingserver.repository.anime;


import com.anime.streamingserver.entity.anime.Animation;
import com.anime.streamingserver.entity.anime.Tags;
import com.anime.streamingserver.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AnimationRepository extends JpaRepository<Animation, Long> {
    @Query("SELECT anim.id, anim.title, anim.thumbnail FROM Animation anim WHERE anim.createTime BETWEEN :startTime AND :endTime")
    List<Animation> getAnimationDateRange(@Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime);

    @Query("SELECT anim FROM Animation anim")
    List<Animation> findAnimationByKeyword(String keyword);
    /*
    List<Animation> getUserRecentViewAnimation(User user);
    List<Animation> findAnimationByTag(Tags tag);
    List<Animation> findAnimationByTag(List<Tags> tag);
    double getAvgRatingByAnimation(Animation animation);
     */
}
