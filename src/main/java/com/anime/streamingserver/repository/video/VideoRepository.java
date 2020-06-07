package com.anime.streamingserver.repository.video;


import com.anime.streamingserver.entity.anime.Animation;
import com.anime.streamingserver.entity.video.VideoInfo;

import java.util.List;

public interface VideoRepository {
    List<VideoInfo> findAllVideoByAnimation(Animation animation);
}
