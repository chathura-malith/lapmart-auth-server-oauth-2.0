package com.chathura.lapmart.auth_server.advisor;

import com.chathura.lapmart.auth_server.exception.DuplicateEntyException;
import com.chathura.lapmart.auth_server.util.StandardResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(DuplicateEntyException.class)
    public ResponseEntity<StandardResponseDto> handelDuplicateEntyException(DuplicateEntyException e){
        return new ResponseEntity<>(
                new StandardResponseDto(409,e.getMessage(),null),
                HttpStatus.CONFLICT
        );
    }
}
