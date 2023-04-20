package com.example.kimbord.domain.board_user.domain;


import com.example.kimbord.domain.board.domain.Board;
import com.example.kimbord.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;


@Entity
@Getter
@AllArgsConstructor
@Builder
@Table(name="badBoardUser", uniqueConstraints=@UniqueConstraint(columnNames={"username", "boardId"}))
public class BadCheckBoardUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userName")
    private User username;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boardId")
    private Board boardId;


    public BadCheckBoardUser() {

    }
}
