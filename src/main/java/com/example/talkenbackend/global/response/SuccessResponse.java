package com.example.talkenbackend.global.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuccessResponse<T> {

    private int code;
    private String message;
    private T data;

    public static <Void> ResponseEntity<SuccessResponse<Void>> toResponseEntity() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(SuccessResponse.<Void>builder()
                        .code(HttpStatus.OK.value())
                        .message(HttpStatus.OK.getReasonPhrase())
                        .build());
    }

    public static <T> ResponseEntity<SuccessResponse<T>> toResponseEntity(String message) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(SuccessResponse.<T>builder()
                        .code(HttpStatus.OK.value())
                        .message(message)
                        .data(null)
                        .build());
    }

    public static <T> ResponseEntity<SuccessResponse<T>> toResponseEntity(String message, T data) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(SuccessResponse.<T>builder()
                        .code(HttpStatus.OK.value())
                        .message(message)
                        .data(data)
                        .build());
    }
}
