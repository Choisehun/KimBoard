package com.example.kimbord.controller.core.user;

import com.example.kimbord.domain.user.service.join.UserJoinService;
import com.example.kimbord.domain.user.service.join.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserJoinController {

    private final UserJoinService userJoinService;

    @GetMapping("/join-form")
    public String userJoinForm() {
        return "join/joinForm";
    }

    @PostMapping("/join")
    public String userJoin(@ModelAttribute UserDto userDto) {

        if (userJoinService.userJoin(userDto)) {
            return "redirect:/";
        } else {
            throw new DuplicateKeyException("이름이중복되었습니다.");
        }
    }
}
