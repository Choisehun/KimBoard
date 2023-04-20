package com.example.kimbord.domain.user.domain;

import com.example.kimbord.controller.advice.UserControllerAdvice;
import com.example.kimbord.domain.user.service.join.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
        //name,password 체크
        long countByName(String name);
        boolean existsByPassword(String password);
       
        //id찾기
        User findByName(String name);

        //verify 리스트(verify 값이 ㅇ일때와 2일때)
        List<User> findByVerifyEquals(int verify);
        List<User> findByVerify(int verify);

        //update
        @Modifying
        @Query(value = "update User user set user.verify=0 where user.id=:id")
        void updateVerify(@Param("id") Long id);



}
