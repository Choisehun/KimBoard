package com.example.kimbord.domain.youtubeboard.service.dto;

import lombok.Getter;

@Getter
public class YoutubeBoardWriteDto {

    private String youtubeTitle;
    private String youtubeId;


    public YoutubeBoardWriteDto(String youtubeTitle, String youtubeId) {
        this.youtubeTitle = youtubeTitle;
        this.youtubeId = youtubeId;
    }


}
