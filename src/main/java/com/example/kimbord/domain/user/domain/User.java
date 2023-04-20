package com.example.kimbord.domain.user.domain;


import lombok.Getter;

import javax.persistence.*;

/**
 * The type User.
 */
@Entity
@Table(name="users")
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 40)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false,length = 14)
    private String phone;

    @Column(nullable = false, columnDefinition = "int default 2")
    private  int verify;


    @PrePersist
    public void prePersist() {
        this.verify = 2;
    }

    public User(String name, String password, String phone) {
        this.name = name;
        this.password = password;
        this.phone = phone;
    }

    public User(String name, String password) {
            this.name=name;
            this.password=password;
    }





    public User() {

    }


}
