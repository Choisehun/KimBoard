package com.example.kimbord.controller.core.user;

import com.example.kimbord.domain.user.service.delete.UserPendingDeleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/delete")
public class UserPendingDelete {

    private final UserPendingDeleteService userPendingDeleteService;

    @PostMapping("/pendingdelete")
    public String dependingdelete(@RequestParam("id") long id){
        userPendingDeleteService.delete(id);
        return "redirect:/list/board-list";
    }


}
