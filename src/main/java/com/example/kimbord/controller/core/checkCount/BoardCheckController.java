package com.example.kimbord.controller.core.checkCount;

import com.example.kimbord.domain.board_user.service.BadCheckUserService;
import com.example.kimbord.domain.board_user.service.BoardUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/test")
@RequiredArgsConstructor
public class BoardCheckController {


    private final BoardUserService boardUserService;
    private final BadCheckUserService badCheckUserService;

    @GetMapping("/update/{type}/{id}")
    public String addLike(@SessionAttribute("username")String userName,@PathVariable("id") Long id,@PathVariable("type") String type,
                          HttpServletResponse response) throws IOException {
        System.out.println(id+userName+"타입은:" + type);
        if(type.equals("like")){
            System.out.println("좋아요컨트롤");
            boolean result = boardUserService.addLike(id, userName);
            if(result){
                return "redirect:/read/{id}";
            }else{
                response.setContentType("text/html; charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.println("<script>alert('이미 좋아요를 누르셨습니다.'); window.location.href='/read/" + id + "';</script>");
                out.flush();
                return "redirect:/read/{id}";
            }
        }else{
            System.out.println("tlfgdj");
           boolean result = badCheckUserService.addBad(id,userName);
           if(result){
               return "redirect:/read/{id}";
           }else{
               response.setContentType("text/html; charset=UTF-8");
               PrintWriter out = response.getWriter();
               out.println("<script>alert('이미 싫어요를 누르셨습니다.'); window.location.href='/read/" + id + "';</script>");
               out.flush();
               return "redirect:/read/{id}";
           }
        }


    }
}

