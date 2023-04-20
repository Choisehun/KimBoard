package com.example.kimbord.domain.board.service.dto;


import com.example.kimbord.domain.board.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class BoardDto {
    private Long id;
    private String boardName;
    private String boardTitle;
    private String boardContent;
    private int likeCount;
    private int badCount;
    private int boardHits;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

    public BoardDto(Long id, String boardName, String boardTitle, String boardContent, int likeCount, int badCount, int boardHits, LocalDateTime createdTime, LocalDateTime updatedTime) {
        this.id = id;
        this.boardName = boardName;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.likeCount = likeCount;
        this.badCount = badCount;
        this.boardHits = boardHits;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }

    public BoardDto(){

    }

    public BoardDto(Long id,String boardTitle, String boardName, int boardHits, LocalDateTime createdTime) {
            this.id = id;
            this.boardTitle = boardTitle;
            this.boardName =boardName;
            this.boardHits = boardHits;
            this.createdTime = createdTime;

    }


    public BoardDto(Board board) {
        this.id = board.getId();
        this.boardName = board.getBoardName();
        this.boardTitle = board.getBoardTitle();
        this.boardContent = board.getBoardContent();
        this.likeCount = board.getLikeCount();
        this.badCount = board.getBadCount();
        this.boardHits = board.getBoardHits();
        this.createdTime = board.getCreatedTime();
        this.updatedTime = board.getCreatedTime();
    }
}
