package com.example.kimbord.domain.board_user.service;

import com.example.kimbord.domain.board.domain.Board;
import com.example.kimbord.domain.board.domain.BoardRepository;
import com.example.kimbord.domain.board_user.domain.LikeCheckBoardUser;
import com.example.kimbord.domain.board_user.domain.LikeCheckBoardUserRepository;
import com.example.kimbord.domain.user.domain.User;
import com.example.kimbord.domain.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardUserService {
    private final LikeCheckBoardUserRepository likeCheckBoardUserRepository;
    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    public boolean addLike(Long boardId, String userName) {
        User user = userRepository.findByName(userName);
        Optional<Board> board = boardRepository.findById(boardId);

        Optional<LikeCheckBoardUser> boardUserOpt = likeCheckBoardUserRepository.findByUsernameAndBoardId(user, board.get());
        if (boardUserOpt.isPresent()) {
            return false;
        } else {
            System.out.println("asdasdasdzzzzzdasdasd");
            LikeCheckBoardUser likeCheckBoardUser = LikeCheckBoardUser.builder().username(user).boardId(board.get()).build();
            likeCheckBoardUserRepository.save(likeCheckBoardUser);

            Board updatedBoard = board.get();
            updatedBoard.increaseLikeCount();
            boardRepository.save(updatedBoard);
            return true;
        }
    }
}
