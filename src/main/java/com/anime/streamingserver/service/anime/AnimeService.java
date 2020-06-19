package com.anime.streamingserver.service.anime;

import com.anime.streamingserver.dto.anime.AnimeDto;
import com.anime.streamingserver.dto.anime.NewAnimeDto;
import com.anime.streamingserver.dto.anime.NewAnimeListDto;
import com.anime.streamingserver.dto.anime.UploadAnimeDataDto;
import com.anime.streamingserver.entity.anime.*;
import com.anime.streamingserver.repository.anime.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;


@Service
public class AnimeService {

    @Autowired
    private AnimationRepository animationRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private GenreCategoryRepository genreCategoryRepository;

    @Autowired
    private TagRepository tagRepository;

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

    public AnimeDto getAnimationById(Long id) {
        AnimeDto animeDto = new AnimeDto();

        Optional<Animation> animationOptional = animationRepository.findById(id);

        Animation animationItem = animationOptional.orElseThrow(NoSuchElementException::new);

        animeDto.setId(animationItem.getId());
        animeDto.setTitle(animationItem.getTitle());
        animeDto.setContent(animationItem.getContent());
        animeDto.setCreateTime(animationItem.getCreateTime());
        animeDto.setUpdateTime(animationItem.getUpdateTime());
        animeDto.setThumbnail(animationItem.getThumbnail());
        animeDto.setAge(animationItem.getAge());
        animeDto.setMakeInfo(animationItem.getMakeInfo());
        animeDto.setGenreCategories(animationItem.getGenreCategories());
        animeDto.setTagCategories(animationItem.getTagCategories());


        return animeDto;
    }


    // TODO : 나중에 명령(업데이트, 삽입, 삭제) 관련 로직들만 별도의 서비스로 분리하기

    @Transactional
    public void addAnimation(UploadAnimeDataDto uploadAnimeDataDto){
        insertAnimation(uploadAnimeDataDto);
    }

    public void updateAnimation(UploadAnimeDataDto uploadAnimeDataDto){
        insertAnimation(uploadAnimeDataDto);
    }

    private void insertAnimation(UploadAnimeDataDto uploadAnimeDataDto) {
        Animation animation = new Animation();

        animation.setTitle(uploadAnimeDataDto.getTitle());
        animation.setContent(uploadAnimeDataDto.getContent());
        animation.setMakeInfo(uploadAnimeDataDto.getMakeInfo());
        animation.setAge(uploadAnimeDataDto.getAge());
        animation.setThumbnail(uploadAnimeDataDto.getThumbnail());

        List<Genre> genres = new ArrayList<Genre>();
        List<GenreCategory> genreCategories = new ArrayList<GenreCategory>();
        List<Tag> tags = new ArrayList<Tag>();
        List<TagCategory> tagCategories = new ArrayList<TagCategory>();


        for(String genreName : uploadAnimeDataDto.getGenres()) {
            GenreCategory genreCategory = new GenreCategory();

            Genre genre = new Genre();
            genre.setGenre(genreName);

            genreCategory.setGenre(genre);
            genreCategory.getGenre().getGenreCategories().add(genreCategory);

            genreCategory.setAnimation(animation);
            genreCategory.getAnimation().getGenreCategories().add(genreCategory);

            genres.add(genre);
            genreCategories.add(genreCategory);
        }

        for(String tagName : uploadAnimeDataDto.getTags()) {
            TagCategory tagCategory = new TagCategory();

            Tag tag = new Tag();
            tag.setTag(tagName);


            tagCategory.setTag(tag);
            tagCategory.getTag().getTagCategories().add(tagCategory);

            tagCategory.setAnimation(animation);
            tagCategory.getAnimation().getTagCategories().add(tagCategory);

            tags.add(tag);
            tagCategories.add(tagCategory);
        }

        genreRepository.saveAll(genres);
        tagRepository.saveAll(tags);

        genreCategoryRepository.saveAll(genreCategories);
        tagCategoryRepository.saveAll(tagCategories);

        animationRepository.save(animation);
    }

    public void deleteAnimation(Long id){
        // TODO : GenreCategory, TagCategory 에서 삭제한 애니메이션 id가 포함된 row들 제거하는 부분 추가.
        animationRepository.deleteById(id);
    }
}
