package com.example.kimbord.controller.advice;

import com.example.kimbord.controller.core.user.UserJoinController;
import com.example.kimbord.controller.core.user.UserLoginController;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@org.springframework.web.bind.annotation.ControllerAdvice(assignableTypes = {UserJoinController.class, UserLoginController.class})
public class UserControllerAdvice {

    @ExceptionHandler(DuplicateKeyException.class)
    public String handleDuplicateKeyException(DuplicateKeyException ex, Model model, HttpServletRequest request) {
        String errMsg = ex.getMessage();
        String referer = request.getHeader("Referer");

            if(referer != null && referer.contains("login")){
                model.addAttribute("loginError",errMsg);
                return "join/loginForm";
            }else{

            model.addAttribute("joinError", errMsg);
            return "join/joinForm";
            }




    }

}
