package com.anime.streamingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class AnimeStreamingServer {

    public static void main(String[] args) {
        SpringApplication.run(AnimeStreamingServer.class,args);
    }
}
