package com.example.kimbord.controller.core.board;


import com.example.kimbord.domain.board.domain.Board;
import com.example.kimbord.domain.board.service.dto.BoardDto;
import com.example.kimbord.domain.board.service.dto.ReplyDto;
import com.example.kimbord.domain.board.service.write.WriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/write")
public class writeController {

    private final WriteService writeService;


    @GetMapping("/write-form")
    public String writeForm(@SessionAttribute("username") String name, Model model){
        model.addAttribute("username",name);
        return "freeBoard/writeForm";
    }

    @PostMapping("writer")
    public String writer(@ModelAttribute BoardDto boardDto){
        writeService.write(boardDto);
        return "redirect:/list/board-list";
    }

    @PostMapping("reply/{id}")
    public String replyWriter(@ModelAttribute ReplyDto replyDto,@SessionAttribute("username") String replyName,@PathVariable("id") Board board){

        System.out.println("아이디"+board+replyName);
        writeService.replyWrite(replyDto,replyName,board);
        return "redirect:/read/{id}";

    }



}
