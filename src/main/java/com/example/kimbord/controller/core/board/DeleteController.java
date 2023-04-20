package com.example.kimbord.controller.core.board;


import com.example.kimbord.domain.board.service.delete.DeleteService;
import com.example.kimbord.domain.board.service.dto.ReplyDto;
import com.example.kimbord.domain.board.service.modify.ModifyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/delete")
public class DeleteController {

    private final DeleteService deleteService;
    private final ModifyService modifyService;

    @GetMapping("{id}")
    public String delete(@PathVariable("id") Long id){
        System.out.println("deelte");
        deleteService.del(id);
        return "redirect:/list/board-list";
    }

    @PostMapping("{replyId}")
    public String replyDelete(@PathVariable("replyId") Long replyId,
                              @SessionAttribute("boardId")Long id,
                              RedirectAttributes redirectAttributes,
                              @SessionAttribute("username")String name){
        ReplyDto replyDto = modifyService.findByID(replyId);

        redirectAttributes.addAttribute("id",id);
        System.out.println("삭제아이디입니다: " + replyDto.getReplyName() + " "+ "유저네임: " + name);

        if(name.equals(replyDto.getReplyName())){
            deleteService.replyDel(replyId);
            System.out.println("삭제성공");
            return "redirect:/read/{id}";

        }else{
            System.out.println("삭제실패");
            return "redirect:/read/{id}";
        }

    }



}
