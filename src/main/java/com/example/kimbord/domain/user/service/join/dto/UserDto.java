package com.example.kimbord.domain.user.service.join.dto;


import com.example.kimbord.domain.user.domain.User;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String password;
    private String phone;
    private int verify;

    public UserDto(String name, String password, String phone, int verify) {
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.verify = verify;
    }

    public static UserDto from(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setPhone(user.getPhone());
        // set other properties as needed
        return userDto;
    }


    public UserDto(){

    }



}
