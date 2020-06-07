package com.anime.streamingserver.dto.anime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.WeakHashMap;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class NewAnimeListDto {
    private WeakHashMap<String, List<NewAnimeDto>> animeList;
}
