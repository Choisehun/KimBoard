package com.example.kimbord.controller.core.board;


import com.example.kimbord.domain.board.domain.Board;
import com.example.kimbord.domain.board.service.dto.BoardDto;
import com.example.kimbord.domain.board.service.dto.ReplyDto;
import com.example.kimbord.domain.board.service.list.ListService;
import com.example.kimbord.domain.board.service.read.ReadService;
import com.example.kimbord.domain.user.domain.User;
import com.example.kimbord.domain.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/read")
@SessionAttributes("boardId")
public class ReadController {

    private final ReadService readService;
    private final UserRepository userRepository;
    private final ListService listService;




    @GetMapping("{id}")
    public String read(@PathVariable Long id, Model model){

        readService.hitUpdate(id);
        model.addAttribute("boardId",id);

        List<ReplyDto> replyDtoList = listService.replyList(id);
        model.addAttribute("replyList",replyDtoList);


        BoardDto boardDto  = readService.read(id);
        model.addAttribute("boardRead",boardDto);
        return "freeBoard/boardRead";
    }

//    @GetMapping("updateLikeCount/{id}")
//    public String updateLike(@PathVariable("id") Long id){
//        System.out.println("controller" + id + "username: ");
//        readService.lickUpdate(id);
//        return "redirect:/read/{id}";
//
//    }




//    @GetMapping("updateBadCount/{id}")
//    public String BadLike(@PathVariable("id") Long id,Model model){
//        System.out.println("controller" + id);
//        readService.badUpdate(id);
//        return "redirect:/read/{id}";
//
//    }

}
