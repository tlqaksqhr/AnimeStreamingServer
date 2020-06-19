package com.anime.streamingserver;

import com.anime.streamingserver.config.AppProperties;
import com.anime.streamingserver.service.video.configuration.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class, AppProperties.class
})
public class AnimeStreamingServer {

    public static void main(String[] args) {
        SpringApplication.run(AnimeStreamingServer.class,args);
    }
}
