package com.example.kimbord.domain.board_user.domain;

import com.example.kimbord.domain.board.domain.Board;
import com.example.kimbord.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BadCheckBoardUserRepository extends JpaRepository<BadCheckBoardUser,Long> {
    Optional<BadCheckBoardUser> findByUsernameAndBoardId(User user, Board board);



}
