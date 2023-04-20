package com.example.kimbord.domain.youtubeboard.service.dto;

import com.example.kimbord.domain.youtubeboard.domain.YoutubeBoard;
import lombok.Getter;

@Getter
public class YoutubeBoardListDto {

    private String youtubeTitle;
    private String youtubeId;

    public YoutubeBoardListDto(YoutubeBoard youtubeBoard){
        this.youtubeTitle=youtubeBoard.getYoutubeTitle();
        this.youtubeId=youtubeBoard.getYoutubeId();
    }

    public YoutubeBoardListDto(){}
}
