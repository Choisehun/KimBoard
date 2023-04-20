package com.example.kimbord.domain.board_user.service;

import com.example.kimbord.domain.board.domain.Board;
import com.example.kimbord.domain.board.domain.BoardRepository;
import com.example.kimbord.domain.board_user.domain.BadCheckBoardUser;
import com.example.kimbord.domain.board_user.domain.BadCheckBoardUserRepository;
import com.example.kimbord.domain.user.domain.User;
import com.example.kimbord.domain.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BadCheckUserService {
    private final UserRepository userRepository;
    private final BoardRepository boardRepository;
    private final BadCheckBoardUserRepository badCheckBoardUserRepository;

    public boolean addBad(Long boardId, String userName){
        User user = userRepository.findByName(userName);
        Optional<Board> board = boardRepository.findById(boardId);

        Optional<BadCheckBoardUser> badUserOpt = badCheckBoardUserRepository.findByUsernameAndBoardId(user, board.get());

        if(badUserOpt.isPresent()){
            return false;
        }else{
            BadCheckBoardUser badCheckBoardUser = BadCheckBoardUser.builder().username(user).boardId(board.get()).build();
            badCheckBoardUserRepository.save(badCheckBoardUser);

            Board updatedBoard =board.get();
            updatedBoard.increaseBadCount();
            boardRepository.save(updatedBoard);
            return true;
        }

    }

}
