package com.example.kimbord.domain.board.service.dto;

import com.example.kimbord.domain.board.domain.Board;
import com.example.kimbord.domain.board.domain.Reply;
import lombok.Data;

import javax.persistence.*;

@Data
public class ReplyDto {

    Long id;
    private String replyName;
    private String replyContent;
    private Board board;

    public ReplyDto(String replyContent) {
        this.replyContent = replyContent;
    }

    public ReplyDto(){

    }


    public ReplyDto(Reply reply) {
        this.id = reply.getId();
        this.replyName = reply.getReplyName();
        this.replyContent = reply.getReplyContent();
    }
}
