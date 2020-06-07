package com.anime.streamingserver.repository.anime;

import com.anime.streamingserver.entity.anime.Animation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class AnimeRepositoryTest {

    @Autowired
    AnimationRepository animationRepository;

    @PersistenceContext
    EntityManager em;

    @Test
    public void getAnimationDateRangeTest(){
        Animation animation = new Animation();
        animation.setAge(15);
        animation.setContent("카구야 님은 연애하고 싶어");
        animation.setTitle("카구야 님은 연애하고 싶어");
        animation.setMakeInfo("제작사 : 쿄애니");
        animationRepository.save(animation);


        Animation animation2 = new Animation();
        animation2.setAge(20);
        animation2.setContent("Bang Dream! Season 3");
        animation2.setTitle("Bang Dream! Season 3");
        animation2.setMakeInfo("제작사 : 산지겐");
        animationRepository.save(animation2);


        LocalDateTime startTime = LocalDateTime.of(2020,04,01,0,0,0);
        LocalDateTime endTime = LocalDateTime.of(2020,07,01,0,0,0);

        List<Animation> animeResult = animationRepository.getAnimationDateRange(startTime, endTime);

        for(Animation anime : animeResult) {
            System.out.println("anime = " + anime);
        }

        assertThat(animeResult.size()).isEqualTo(2);
    }

    @Test
    public void saveAnimationTest() {
        Animation animation = new Animation();
        animation.setAge(15);
        animation.setContent("카구야 님은 연애하고 싶어");
        animation.setTitle("카구야 님은 연애하고 싶어");
        animation.setMakeInfo("제작사 : 쿄애니");
        animationRepository.save(animation);

        Animation animation2 = new Animation();
        animation2.setAge(20);
        animation2.setContent("Bang Dream! Season 3");
        animation2.setTitle("Bang Dream! Season 3");
        animation2.setMakeInfo("제작사 : 산지겐");
        animationRepository.save(animation2);

        List<Animation> animeResult = animationRepository.findAll();

        assertThat(animeResult.size()).isEqualTo(2);
    }

    @Test
    public void deleteAnimationTest() {

    }
}
