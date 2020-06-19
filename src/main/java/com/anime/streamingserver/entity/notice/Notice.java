package com.anime.streamingserver.entity.notice;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Notice {

    @Id @GeneratedValue
    @Column(name = "notice_id")
    private Long id;

    private String title;
    private String content;
}
