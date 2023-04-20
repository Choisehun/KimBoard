package com.example.kimbord.domain.user.service.delete;


import com.example.kimbord.domain.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserPendingDeleteService {

    private final UserRepository userRepository;

    public void delete(long id){
        userRepository.deleteById(id);
    }
}
