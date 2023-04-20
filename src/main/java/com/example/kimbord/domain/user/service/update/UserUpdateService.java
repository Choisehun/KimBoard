package com.example.kimbord.domain.user.service.update;

import com.example.kimbord.domain.user.domain.User;
import com.example.kimbord.domain.user.domain.UserRepository;
import com.example.kimbord.domain.user.service.update.dto.UpdateServiceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserUpdateService {

        private final UserRepository userRepository;


        @Transactional
       public void updateVerify(long id){
                userRepository.updateVerify(id);

       }

}
