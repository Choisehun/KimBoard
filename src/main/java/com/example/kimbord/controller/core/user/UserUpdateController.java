package com.example.kimbord.controller.core.user;


import com.example.kimbord.domain.user.service.update.UserUpdateService;
import com.example.kimbord.domain.user.service.update.dto.UpdateServiceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/update")
public class UserUpdateController {

    private final UserUpdateService userUpdateService;


    @PostMapping("/updateVerify")
    public String updateVerify(@RequestParam("id")long id){
        System.out.println("asdasdasd22");
        userUpdateService.updateVerify(id);

        // 결과를 리턴할 페이지로 이동하는 코드 추가 필요
        return "redirect:/";
    }
}
