package com.example.kimbord.controller.core.user;


import com.example.kimbord.domain.user.domain.User;
import com.example.kimbord.domain.user.domain.UserRepository;
import com.example.kimbord.domain.user.service.join.dto.UserDto;
import com.example.kimbord.domain.user.service.login.UserLoginService;
import com.example.kimbord.domain.user.service.list.UserListService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Optional;


@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
@SessionAttributes({"username"})
public class UserLoginController {

    private final UserLoginService loginService;
    private final UserListService userListService;
    private final UserRepository userRepository;


    @GetMapping("login-form")
    public String loginForm(SessionStatus sessionStatus){
        sessionStatus.setComplete();
        return "join/loginForm";
        }


    @PostMapping("login")
    public String login(@ModelAttribute UserDto userDto,Model model,@RequestParam("name") String name) {
        System.out.println(name);
      User user = userRepository.findByName(name);
        switch (loginService.login(userDto)) {
            case SUCCESS_USER:
                model.addAttribute("username",name);
                model.addAttribute("userid",user.getId());
                return "redirect:/users/homeForm";
            case SUCCESS_ADMiN:
                return "join/adminForm";
            case NO_USER:
                throw new DuplicateKeyException("아이디가없습니다");
            case INVALID_PW:
                throw new DuplicateKeyException("아이디 비밀번호를 다시 확인해주세요1");
        }

        throw new RuntimeException("로그인 처리 중 오류 발생");
    }



}
