package com.example.kimbord.domain.board.domain;


import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name="reply")
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    private String replyName;

    @Column
    private String replyContent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;


    public Reply(String replyContent, String replyName, Board board) {
        this.replyContent = replyContent;
        this.replyName = replyName;
        this.board = board;
    }

    public Reply(){

    }


    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }
}
