package com.example.kimbord.enums;

public enum LoginTypeCode {
    SUCCESS_ADMiN("admin 로그인 성공", 1),
    SUCCESS_USER("user 로그인 성공", 1),
    NO_USER("존재하지 않는 아이디입니다.", 2),
    INVALID_PW("아이디 비밀번호를 확인하세요.", 3);


    private final String message;
    private final int code;

    LoginTypeCode(String message, int code){
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
