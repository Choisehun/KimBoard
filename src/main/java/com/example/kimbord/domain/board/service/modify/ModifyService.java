package com.example.kimbord.domain.board.service.modify;

import com.example.kimbord.domain.board.domain.Board;
import com.example.kimbord.domain.board.domain.BoardRepository;
import com.example.kimbord.domain.board.domain.Reply;
import com.example.kimbord.domain.board.domain.ReplyRepository;
import com.example.kimbord.domain.board.service.dto.BoardDto;
import com.example.kimbord.domain.board.service.dto.ReplyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ModifyService {

    private final BoardRepository boardRepository;
    private final ReplyRepository replyRepository;

    public BoardDto findById(long id){
     Optional<Board> OptinalBoard =  boardRepository.findById(id);

     if(OptinalBoard.isPresent()){
         Board board = OptinalBoard.get();
         BoardDto boardDto = new BoardDto(board);
         return boardDto;

     }else {
         return null;
     }

    }

    //
    public ReplyDto findByID(Long id){
        Optional<Reply> optionalReply = replyRepository.findById(id);

        if(optionalReply.isPresent()){
            Reply reply = optionalReply.get();
            ReplyDto replyDto = new ReplyDto(reply);
            return replyDto;

        }else{
            return null;
        }

    }


    public void modify(Long id, String content) {
        Optional<Reply> optionalReply = replyRepository.findById(id);
        if (optionalReply.isPresent()) {
            Reply reply = optionalReply.get();
            reply.setReplyContent(content);
            replyRepository.save(reply);
        } else {
            return;
        }
    }


    @Transactional
    public void update(Long id, String title, String content){

       boardRepository.updateBoard(id,title,content);
    }



}




