package com.example.kimbord.controller.core.board;


import com.example.kimbord.domain.board.domain.Board;
import com.example.kimbord.domain.board.service.dto.BoardDto;
import com.example.kimbord.domain.board.service.dto.ReplyDto;
import com.example.kimbord.domain.board.service.list.ListService;
import com.example.kimbord.domain.board.service.modify.ModifyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
@RequestMapping("/modify")
public class ModifyController {

    private final ModifyService modifyService;
    private final ListService listService;


    @GetMapping("/update/{id}")
    public String modifyForm(@PathVariable("id")Long id, Model model){
        BoardDto boardDto = modifyService.findById(id);
        model.addAttribute("modifyDetail",boardDto);
        return "freeBoard/modifyForm";
    }

    @PostMapping("updates")
    public String update(@RequestParam("boardId")Long boardId, @RequestParam("boardTitle") String title, @RequestParam("boardContent") String content){

        System.out.println(content);

        modifyService.update(boardId,title,content);
        return "redirect:/list/board-list";

    }
    //댓글수정

    @GetMapping("/{replyId}")
    public String replyModifyForm(@PathVariable("replyId")Long replyId,Model model){
        System.out.println(replyId);
        model.addAttribute("replyModify",modifyService.findByID(replyId));
        return "freeBoard/replyModifyForm";

    }

    @PostMapping("update/{replyId}")
    public String replyModify(@PathVariable("replyId") Long replyId,
                              @RequestParam String content,
                              RedirectAttributes redirectAttributes,
                              @SessionAttribute("boardId") Long id,
                              @SessionAttribute("username")String name) {
        System.out.println("여기까지오나?"+replyId+content);
        modifyService.modify(replyId, content);
        redirectAttributes.addAttribute("id",id);
        System.out.println("이건 아이디입니다:" + redirectAttributes + id);
        return "redirect:/read/{id}";
    }



}
