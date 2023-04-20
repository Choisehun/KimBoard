package com.example.kimbord.domain.youtubeboard.service.list;

import com.example.kimbord.domain.youtubeboard.domain.YoutubeBoard;
import com.example.kimbord.domain.youtubeboard.domain.YoutubeBoardRepository;
import com.example.kimbord.domain.youtubeboard.service.dto.YoutubeBoardListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class YoutubeBoardListService {

    private final YoutubeBoardRepository youtubeBoardRepository;

    public List<YoutubeBoardListDto> list(){
        List<YoutubeBoard> youtubeBoardList = youtubeBoardRepository.findAll();
        List<YoutubeBoardListDto> youtubeBoardDtoList = new ArrayList<>();

        for(YoutubeBoard youtubeBoard : youtubeBoardList){
                youtubeBoardDtoList.add(new YoutubeBoardListDto(youtubeBoard));
        }
        return youtubeBoardDtoList;
    }

}
