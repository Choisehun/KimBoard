package com.example.kimbord.domain.user.service.login;


import com.example.kimbord.domain.user.domain.User;
import com.example.kimbord.domain.user.domain.UserRepository;
import com.example.kimbord.domain.user.service.join.dto.UserDto;
import com.example.kimbord.enums.LoginTypeCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserLoginService {

    private final UserRepository userRepository;

    public LoginTypeCode login(UserDto userDto) {

        if (userRepository.countByName(userDto.getName()) == 1 && userRepository.existsByPassword(userDto.getPassword())) {

            User user  = userRepository.findByName(userDto.getName());
            if(user.getVerify()==1){
               return LoginTypeCode.SUCCESS_ADMiN;
           }else if(user.getVerify()==0){
            return LoginTypeCode.SUCCESS_USER;
           }else{
                return LoginTypeCode.NO_USER;
            }
        } else {
            System.out.println(userDto.getVerify());
            return LoginTypeCode.INVALID_PW;
        }

    }
}
