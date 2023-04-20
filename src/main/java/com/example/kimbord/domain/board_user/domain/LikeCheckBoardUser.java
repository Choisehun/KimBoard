package com.example.kimbord.domain.board_user.domain;


import com.example.kimbord.domain.board.domain.Board;
import com.example.kimbord.domain.user.domain.User;
import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@AllArgsConstructor
@Builder
@Table(name="likeBoardUser", uniqueConstraints=@UniqueConstraint(columnNames={"username", "boardId"}))
public class LikeCheckBoardUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userName")
    private User username;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boardId")
    private Board boardId;


    public LikeCheckBoardUser() {

    }
}
