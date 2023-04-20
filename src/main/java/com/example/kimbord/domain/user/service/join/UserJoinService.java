package com.example.kimbord.domain.user.service.join;

import com.example.kimbord.domain.user.domain.User;
import com.example.kimbord.domain.user.domain.UserRepository;
import com.example.kimbord.domain.user.service.join.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserJoinService {

    private final UserRepository userRepository;

    public boolean userJoin(UserDto userDto){

        long count = userRepository.countByName(userDto.getName());

        if(count==1){
            return false;
        }

        User user  = new User(userDto.getName(), userDto.getPassword(), userDto.getPhone());
        userRepository.save(user);
        return true;

    }
}
