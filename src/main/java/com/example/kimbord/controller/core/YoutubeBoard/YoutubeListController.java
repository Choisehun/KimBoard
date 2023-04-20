package com.example.kimbord.controller.core.YoutubeBoard;


import com.example.kimbord.domain.youtubeboard.service.dto.YoutubeBoardListDto;
import com.example.kimbord.domain.youtubeboard.service.list.YoutubeBoardListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("youtubeList")
public class YoutubeListController {

    private final YoutubeBoardListService youtubeBoardListService;



    @GetMapping("youtube-List")
    public String list(Model model){
        List<YoutubeBoardListDto> youtubeBoardDtoList = youtubeBoardListService.list();
        model.addAttribute("youtubeList",youtubeBoardDtoList);
        return "/youtube/youtubeList";

    }


}
