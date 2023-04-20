package com.example.kimbord.domain.board.service.list;

import com.example.kimbord.domain.board.domain.Board;
import com.example.kimbord.domain.board.domain.BoardRepository;
import com.example.kimbord.domain.board.domain.Reply;
import com.example.kimbord.domain.board.domain.ReplyRepository;
import com.example.kimbord.domain.board.service.dto.BoardDto;
import com.example.kimbord.domain.board.service.dto.ReplyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ListService {

    private final BoardRepository boardRepository;
    private final ReplyRepository replyRepository;

    public List<BoardDto> list(){
      //  List<Board> boardList = boardRepository.findAll();
        List<Board> boardList = boardRepository.findTop3ByOrderByLikeCountDesc();
        List<BoardDto> boardDtoList = new ArrayList<>();

        for(Board board:boardList){
            boardDtoList.add(new BoardDto(board));
        }

        return  boardDtoList;
    }



    //댓글
    public List<ReplyDto> replyList(Long id){
        List<Reply> replyList = replyRepository.findByBoardId(id);
        List<ReplyDto> replyDtoList = new ArrayList<>();

        for(Reply reply:replyList){
            replyDtoList.add(new ReplyDto(reply));
        }
        return replyDtoList;
    }

    //페이징
    
    public Page<BoardDto> pageList(Pageable pageable){
        int page = pageable.getPageNumber()-1;
        int limitPage = 10;

        Page<Board> boardPage =
                boardRepository.findAll(PageRequest.of(page,limitPage, Sort.Direction.DESC, "id"));

        return boardPage.map(board -> new BoardDto(
                board.getId(),
                board.getBoardTitle(),
                board.getBoardName(),
                board.getBoardHits(),
                board.getCreatedTime()));

    }





}
