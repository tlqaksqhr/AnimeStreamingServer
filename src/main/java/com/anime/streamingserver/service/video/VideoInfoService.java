package com.anime.streamingserver.service.video;

import com.anime.streamingserver.dto.video.UploadVideoDataDto;
import com.anime.streamingserver.entity.video.VideoInfo;
import com.anime.streamingserver.repository.video.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class VideoInfoService {


    @Autowired
    VideoRepository videoRepository;

    public List<VideoInfo> getVideoListByAnimationID(Long animationID){
        List<VideoInfo> videoInfo = videoRepository.findAllVideoByAnimationID(animationID);
        return videoInfo;
    }

    public void tryInsertVideoInfo(UploadVideoDataDto uploadVideoDataDto){
        VideoInfo videoInfo = new VideoInfo();
    }

    public void confirmInsertVideoInfo(){

    }

    public void cancelInsertVideoInfo(){
        
    }

    public void tryUpdateVideoInfo(UploadVideoDataDto uploadVideoDataDto){

    }

    public void confirmUpdateVideoInfo(){

    }

    public void cancelUpdateVideoInfo(){

    }

    public void tryRemoveVideoInfo(UploadVideoDataDto uploadVideoDataDto){

    }

    public void confirmRemoveVideoInfo(){

    }

    public void cancelRemoveVideoInfo(){

    }
}
