package com.example.kimbord.controller.core.user;

import com.example.kimbord.domain.user.domain.User;
import com.example.kimbord.domain.user.domain.UserRepository;
import com.example.kimbord.domain.user.service.join.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class HomeController {

    private final UserRepository userRepository;

    @GetMapping("homeForm")
    public String sessionId(UserDto userDto, @SessionAttribute("username") String name, Model model){
        System.out.println("여긴homeconrt "+name);
        User user = userRepository.findByName(name);
        System.out.println(user);
        model.addAttribute("usernames", name);
        return "join/home";


    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";

    }



}
