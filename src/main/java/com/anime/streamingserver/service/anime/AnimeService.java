package com.anime.streamingserver.service.anime;

import com.anime.streamingserver.dto.anime.NewAnimeDto;
import com.anime.streamingserver.dto.anime.NewAnimeListDto;
import com.anime.streamingserver.dto.anime.UploadAnimeDataDto;
import com.anime.streamingserver.entity.anime.Animation;
import com.anime.streamingserver.entity.anime.Genre;
import com.anime.streamingserver.entity.anime.Review;
import com.anime.streamingserver.entity.anime.Tags;
import com.anime.streamingserver.entity.user.User;
import com.anime.streamingserver.repository.anime.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.WeakHashMap;


@Service
public class AnimeService {

    @Autowired
    private AnimationRepository animationRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private GenreCategoryRepository genreCategoryRepository;

    @Autowired
    private TagsRepository tagsRepository;

    @Autowired
    private TagCategoryRepository tagCategoryRepository;


    public NewAnimeListDto getNewAnimation() {

        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime[] datePair = getDatePairByNowTime(currentTime);

        LocalDateTime startTime = datePair[0];
        LocalDateTime endTime = datePair[1];

        List<Animation> animeItems = animationRepository.getAnimationDateRange(startTime, endTime);

        WeakHashMap<String, List<NewAnimeDto>> newAnimeList
            = new WeakHashMap<String, List<NewAnimeDto>>();

        for(Animation animation : animeItems) {
            String days = animation.getCreateTime().getDayOfWeek().toString();
            if(!newAnimeList.containsKey(days)) {
                newAnimeList.put(days, new ArrayList<NewAnimeDto>());
            }

            newAnimeList.get(days).add(
                    new NewAnimeDto(animation.getId(),animation.getTitle(), animation.getContent())
            );
        }

        NewAnimeListDto result = new NewAnimeListDto();
        result.setAnimeList(newAnimeList);

        return result;
    }


    private AnimeTerm getAnimeTerm(LocalDateTime createTime){

        int month = createTime.getMonthValue();

        if(month >= 1 && month < 4){
            return AnimeTerm.ONE;
        }else if(month >= 4 && month < 7) {
            return AnimeTerm.TWO;
        }else if(month >=7 && month < 10) {
            return AnimeTerm.THREE;
        }else {
            return AnimeTerm.FOUR;
        }
    }

    private LocalDateTime[] getDatePairByNowTime(LocalDateTime nowTime) {

        AnimeTerm animeTerm = getAnimeTerm(nowTime);
        LocalDateTime[] datePair = new LocalDateTime[2];

        datePair[0] = LocalDateTime.now().minusDays(nowTime.getDayOfWeek().getValue());

        if(animeTerm == AnimeTerm.ONE) {
            datePair[1] = LocalDateTime.of(nowTime.getYear(),3,30,23,59,59);
        }else if(animeTerm == AnimeTerm.TWO){
            datePair[1] = LocalDateTime.of(nowTime.getYear(),6,30,23,59,59);
        }else if(animeTerm == AnimeTerm.THREE) {
            datePair[1] = LocalDateTime.of(nowTime.getYear(),9,30,23,59,59);
        }else {
            datePair[1] = LocalDateTime.of(nowTime.getYear(),12,31,23,59,59);
        }

        return datePair;
    }


    // TODO : 나중에 명령(업데이트, 삽입, 삭제) 관련 로직들만 별도의 서비스로 분리하기

    public void addAnimation(UploadAnimeDataDto uploadAnimeDataDto){

        Animation animation = new Animation();

        animation.setTitle(uploadAnimeDataDto.getTitle());
        animation.setContent(uploadAnimeDataDto.getContent());
        animation.setMakeInfo(uploadAnimeDataDto.getMakeInfo());
        animation.setAge(uploadAnimeDataDto.getAge());
        animation.setThumbnail(uploadAnimeDataDto.getThumbnail());




        animationRepository.save(animation);
    }

    public void deleteAnimation(Animation animation){

        animationRepository.delete(animation);

    }

    public void updateAnimation(Animation animation){

    }
}
