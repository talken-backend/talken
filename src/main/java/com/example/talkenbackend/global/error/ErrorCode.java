package com.example.talkenbackend.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    INVALID_INPUT(HttpStatus.BAD_REQUEST, "유효하지 않은 입력값입니다."),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "지원하지 않는 메서드 타입입니다."),
    ACCESS_DENIED(HttpStatus.FORBIDDEN, "접근이 거부되었습니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "내부 서버 에러입니다."),
    ENTITY_NOT_FOUND(HttpStatus.NOT_FOUND, "Entity를 찾을 수 없습니다."),
    NOT_AUTHORIZED(HttpStatus.BAD_REQUEST, "권한이 없습니다."),

    // resume
    INVALID_KEYWORD(HttpStatus.BAD_REQUEST, "키워드는 5개를 초과할 수 없습니다."),

    // user
    DUPLICATE_EMAIL(HttpStatus.BAD_REQUEST, "중복된 이메일이 존재합니다."),
    INVALID_PASSWORD(HttpStatus.BAD_REQUEST, "패스워드가 일치하지 않습니다."),
    ;

    private final HttpStatus status;
    private final String message;
}
