package com.example.kimbord.controller.core.user;

import com.example.kimbord.domain.user.domain.User;
import com.example.kimbord.domain.user.domain.UserRepository;
import com.example.kimbord.domain.user.service.join.dto.UserDto;
import com.example.kimbord.domain.user.service.list.UserListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class UserAdminController {

    private final UserListService userListService;
    private final UserRepository userRepository;



    @GetMapping("/userList")
    @ResponseBody
    public List<UserDto> userList(){
        List<UserDto> userDtoList = userListService.findByVerifyEquals(0);

        return userDtoList;
    }



    @GetMapping("/userPendingList")
    @ResponseBody
    public List<User> userPendingList() {
        List<User> users = userRepository.findByVerify(2);

        return users;
    }




}
