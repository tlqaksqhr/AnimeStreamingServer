package com.anime.streamingserver.repository.anime;


import com.anime.streamingserver.entity.anime.Animation;
import com.anime.streamingserver.entity.anime.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

    /*
    void addFavorite(Favorite favorite);
    void deleteFavorite(Favorite favorite);
    int countFavoriteByAnimation(Animation animation);

     */
}
