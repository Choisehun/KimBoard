package com.example.kimbord.domain.user.service.update.dto;


import lombok.Getter;

@Getter
public class UpdateServiceDto {

    private Long id;
    private int verify;

    public UpdateServiceDto(Long id, int verify) {
        this.id = id;
        this.verify = verify;
    }

    public UpdateServiceDto(){

    }

    public void setVerify(int verify) {
    }
}
