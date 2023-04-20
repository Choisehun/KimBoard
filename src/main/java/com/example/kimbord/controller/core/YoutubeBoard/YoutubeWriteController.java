package com.example.kimbord.controller.core.YoutubeBoard;

import com.example.kimbord.domain.youtubeboard.service.dto.YoutubeBoardWriteDto;
import com.example.kimbord.domain.youtubeboard.service.write.YoutubeBoardWriterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/youtube")
public class YoutubeWriteController {
    private final YoutubeBoardWriterService youtubeBoardWriterService;


    @GetMapping("youtubeWriteForm")
    public String youtubeWriterForm(@SessionAttribute("username")String name, Model model){
        model.addAttribute("username",name);
        return "/youtube/youtubeWrite";
    }


    @PostMapping("/write")
    public String write(@ModelAttribute YoutubeBoardWriteDto youtubeBoardWriteDto){
        youtubeBoardWriterService.write(youtubeBoardWriteDto);
        return "redirect:/youtubeList/youtube-List";

    }
}
