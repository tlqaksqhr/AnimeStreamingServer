package com.anime.streamingserver.repository.anime;


import com.anime.streamingserver.entity.anime.Animation;
import org.springframework.data.domain.Page;
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

    @Query(
        value = "SELECT anim FROM Animation anim WHERE anim.title LIKE %:keyword%",
        countQuery = "SELECT COUNT(anim.id) FROM Animation anim WHERE anim.title LIKE %:keyword%"
    )
    Page<Animation> findAnimationByKeyword(String keyword);
    /*
    List<Animation> getUserRecentViewAnimation(User user);
    List<Animation> findAnimationByTag(Tag tag);
    List<Animation> findAnimationByTag(List<Tag> tag);
    double getAvgRatingByAnimation(Animation animation);
     */
}
