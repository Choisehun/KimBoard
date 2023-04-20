package com.example.kimbord.domain.youtubeboard.service.write;

import com.example.kimbord.domain.youtubeboard.domain.YoutubeBoard;
import com.example.kimbord.domain.youtubeboard.domain.YoutubeBoardRepository;
import com.example.kimbord.domain.youtubeboard.service.dto.YoutubeBoardWriteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class YoutubeBoardWriterService {

    private final YoutubeBoardRepository youtubeBoardRepository;

    public void write(YoutubeBoardWriteDto youtubeBoardWriteDto){
        YoutubeBoard youtubeBoard = new YoutubeBoard(
                youtubeBoardWriteDto.getYoutubeTitle(),
                youtubeBoardWriteDto.getYoutubeId());
        youtubeBoardRepository.save(youtubeBoard);

    }





}
