package com.example.kimbord.domain.board.service.read;


import com.example.kimbord.domain.board.domain.Board;
import com.example.kimbord.domain.board.domain.BoardRepository;
import com.example.kimbord.domain.board.service.dto.BoardDto;
import com.example.kimbord.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReadService {

    private final BoardRepository boardRepository;

    public BoardDto read(Long id){
        Optional<Board> optionalBoard = boardRepository.findById(id);

        if(optionalBoard.isPresent()){
            Board board = optionalBoard.get();
            BoardDto boardDto = new BoardDto(board);
            return boardDto;

        }else{
            return null;
        }
    }

    @Transactional
    public void hitUpdate(Long id){
        boardRepository.hitUpdate(id);

    }
//
//    @Transactional
//    public void lickUpdate(Long id){
//        System.out.println("service" + id + "username");
//        boardRepository.likeUpdate(id);
//
//    }



//    @Transactional
//    public void badUpdate(Long id){
//        System.out.println("service" + id);
//        boardRepository.badUpdate(id);
//
//    }
}
