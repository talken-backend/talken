package com.example.talkenbackend.global.exception;

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

    // resume
    NOT_INVALID_KEYWORD(HttpStatus.BAD_REQUEST, "키워드는 5개를 초과할 수 없습니다."),
    ;

    private final HttpStatus status;
    private final String message;
}
