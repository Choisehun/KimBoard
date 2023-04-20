package com.example.kimbord.domain.board.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface BoardRepository extends JpaRepository<Board,Long> {


    //조회수
    @Modifying
    @Query(value = "update Board b set b.boardHits=b.boardHits+1 where b.id=:id")
    void hitUpdate(@Param("id") Long id);


    //수정
    @Modifying
    @Query("update Board b set b.boardTitle = :boardTitle, b.boardContent = :boardContent where b.id = :id")
    void updateBoard(@Param("id") Long id, @Param("boardTitle") String boardTitle, @Param("boardContent") String boardContent);


    List<Board> findTop3ByOrderByLikeCountDesc();
}
