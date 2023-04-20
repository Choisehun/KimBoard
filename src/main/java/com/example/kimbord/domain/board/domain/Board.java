package com.example.kimbord.domain.board.domain;


import com.example.kimbord.domain.user.domain.User;
import lombok.Getter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Table(name="board")
@DynamicInsert
public class Board extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String boardName;

    @Column
    private String boardTitle;

    @Column(nullable = false)
    private String boardContent;

    @Column
    private int likeCount;

    @Column
    private int badCount;

    @Column
    private int boardHits;

    @OneToMany(mappedBy = "board")
    private List<Reply> replies = new ArrayList<>();



    public Board(String boardTitle, String boardContent, String boardName) {
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardName = boardName;
    }

    public Board(Long id, String boardName, String boardTitle, String boardContent, int likeCount, int badCount, int boardHits) {
        this.id = id;
        this.boardName = boardName;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.likeCount = likeCount;
        this.badCount = badCount;
        this.boardHits = boardHits;
    }

    public Board(){

    }



    public void update(String boardTitle, String boardContent) {
        this.boardTitle =boardTitle;
        this.boardContent = boardContent;
    }


    public void increaseLikeCount() {
        likeCount++;
    }

    public void increaseBadCount(){
        badCount--;
    }

}
