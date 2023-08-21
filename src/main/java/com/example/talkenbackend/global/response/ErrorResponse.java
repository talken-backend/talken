package com.example.talkenbackend.global.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    private int code;
    private String message;

    public static ResponseEntity<ErrorResponse> toResponseEntity(int code, String message) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ErrorResponse.builder()
                        .code(code)
                        .message(message)
                        .build());
    }
}
