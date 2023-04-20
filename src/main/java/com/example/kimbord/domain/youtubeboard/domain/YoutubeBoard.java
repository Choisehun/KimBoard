package com.example.kimbord.domain.youtubeboard.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@RequiredArgsConstructor
@Getter
@Entity
public class YoutubeBoard {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String youtubeTitle;

    @Column
    private String youtubeId;


    public YoutubeBoard(String youtubeTitle, String youtubeId) {
        this.youtubeTitle = youtubeTitle;
        this.youtubeId = youtubeId;
    }
}
