package com.example.quiz.controller;

import com.example.quiz.exception.NoQuizFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoQuizFoundException.class)
    ResponseEntity<String> handleNoQuizFoundException(NoQuizFoundException e){
        return new ResponseEntity<>("No Quiz Found: "+e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<String> genericException(RuntimeException e){
        return new ResponseEntity<>("INTERNAL SERVER ERROR: "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
