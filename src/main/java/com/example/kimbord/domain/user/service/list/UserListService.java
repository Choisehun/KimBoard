package com.example.kimbord.domain.user.service.list;


import com.example.kimbord.domain.user.domain.User;
import com.example.kimbord.domain.user.domain.UserRepository;
import com.example.kimbord.domain.user.service.join.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserListService {

    private final UserRepository userRepository;

    public List<UserDto> findByVerifyEquals(int verify){
        List<User> UserList = userRepository.findByVerifyEquals(verify);
        List<UserDto> userDtoList = new ArrayList<>();

        for(User user:UserList){
            userDtoList.add(UserDto.from(user));

        }

        return userDtoList;




    }



}
