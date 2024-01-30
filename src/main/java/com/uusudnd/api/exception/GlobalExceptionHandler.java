package com.uusudnd.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MemberNotFound.class)
    public ResponseEntity<ErrorMessage> memberNotFound(Exception e, WebRequest request){
        ErrorMessage errors = new ErrorMessage(404, new Date(), e.getMessage(), "Member Not Found");

        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(GameNotFound.class)
    public ResponseEntity<ErrorMessage> gameNotFound(Exception e, WebRequest request){
        ErrorMessage errors = new ErrorMessage(404, new Date(), e.getMessage(), "Game Not Found");

        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }
}
