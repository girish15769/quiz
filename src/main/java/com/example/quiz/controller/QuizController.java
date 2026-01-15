package com.example.quiz.controller;

import com.example.quiz.entity.Quiz;
import com.example.quiz.service.QuizService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/admin/quizzes")
    @Operation(description = "Create Quiz Api")
    public Quiz createQuiz(@RequestBody Quiz quiz){
        return quizService.createQuiz(quiz);
    }

    @GetMapping("/quizzes/{id}")
    @Operation(description = "Take Quiz Api")
    public Quiz takeQuiz(@PathVariable  Long id){
        return quizService.getQuiz(id);
    }
}
