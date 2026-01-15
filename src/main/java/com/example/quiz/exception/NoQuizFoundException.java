package com.example.quiz.exception;

public class NoQuizFoundException extends RuntimeException{
    public NoQuizFoundException(String message){
        super(message);
    }
}
