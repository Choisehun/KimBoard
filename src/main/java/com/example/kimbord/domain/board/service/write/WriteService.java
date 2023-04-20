package com.example.kimbord.domain.board.service.write;


import com.example.kimbord.domain.board.domain.Board;
import com.example.kimbord.domain.board.domain.BoardRepository;
import com.example.kimbord.domain.board.domain.Reply;
import com.example.kimbord.domain.board.domain.ReplyRepository;
import com.example.kimbord.domain.board.service.dto.BoardDto;
import com.example.kimbord.domain.board.service.dto.ReplyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WriteService {

    private final BoardRepository boardRepository;
    private final ReplyRepository replyRepository;

    public void write(BoardDto boardDto){
        Board board = new Board(boardDto.getBoardTitle(),boardDto.getBoardContent(),boardDto.getBoardName());
        boardRepository.save(board);
    }

    public void replyWrite(ReplyDto replyDto,String replyName,Board board){
        Reply reply = new Reply(replyDto.getReplyContent(),replyName,board);
        replyRepository.save(reply);

    }


}

